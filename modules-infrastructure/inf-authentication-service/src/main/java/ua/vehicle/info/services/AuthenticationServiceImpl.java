package ua.vehicle.info.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ua.vehicle.info.api.dto.authentication.AuthTokenDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;
import ua.vehicle.info.api.dto.users.AppUser;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.external.UserService;
import ua.vehicle.info.utils.PasswordUtils;

/**
 * The type Authentication service.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final long JWT_TOKEN_MINUTES = 1;
    private final UserService userService;
    private final PasswordUtils passwordUtils;
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Nullable
    @Override
    public AuthTokenDto authenticate(AuthUserCredentialsDto authUserCredentialsDto) {
        var userByEmail = userService.getUserByEmail(authUserCredentialsDto.getUsername());
        if (Objects.isNull(userByEmail)) {
            return AuthTokenDto.builder().build();
        }
        var isMatching = passwordUtils.isMatching(authUserCredentialsDto.getPassword(),
                userByEmail.getPassword());
        if (!isMatching) {
            return AuthTokenDto.builder().build();
        }
        return generateToken(userByEmail);
    }

    @Override
    public boolean checkIsValid(AuthTokenDto tokeDto) {
        var username = getUsername(tokeDto.getToken());
        var userByEmail = userService.getUserByEmail(username);
        if (Objects.isNull(userByEmail)) {
            return false;
        }
        return isValid(tokeDto.getToken(), userByEmail);
    }

    @Override
    public AppRole getRoleForAuthentication(AuthTokenDto tokeDto) {
        return null;
    }

    @SuppressRuntimeExceptions
    private String getUsername(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private boolean isExpired(String token) {
        final LocalDateTime expiration = getExpiration(token);
        return expiration.isBefore(LocalDateTime.now());
    }

    private LocalDateTime getExpiration(String token) {
        Date date = getClaimFromToken(token, Claims::getExpiration);
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimResolverFunc) {
        final var claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claimResolverFunc.apply(claims);
    }

    private AuthTokenDto generateToken(AppUser userDetails) {
        Map<String, Object> claims = new HashMap<>();
        var fromTime = LocalDateTime.now();
        var toTime = LocalDateTime.now().plusMinutes(JWT_TOKEN_MINUTES);
        var from = Date.from(fromTime.atZone(ZoneId.systemDefault()).toInstant());
        var to = Date.from(toTime.atZone(ZoneId.systemDefault()).toInstant());
        var token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getEmail())
                .setIssuedAt(from)
                .setExpiration(to)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
        return AuthTokenDto.builder().token(token).build();
    }

    private boolean isValid(String token, AppUser user) {
        final String username = getUsername(token);
        return (username.equals(user.getEmail()) && !isExpired(token));
    }
}
