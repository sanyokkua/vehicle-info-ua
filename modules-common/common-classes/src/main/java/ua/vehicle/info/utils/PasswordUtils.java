package ua.vehicle.info.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Slf4j
@RequiredArgsConstructor
public class PasswordUtils {

    protected final Pbkdf2PasswordEncoder passwordEncoder;

    public String encode(@NonNull String rawPassword) {
        if (StringUtils.isBlank(rawPassword)) {
            throw new IllegalArgumentException("Password is blank");
        }
        return passwordEncoder.encode(rawPassword);
    }

    public boolean isMatching(@NonNull String rawPassword, @NonNull String encodedPasswordFromDB) {
        if (StringUtils.isBlank(rawPassword) || StringUtils.isBlank(encodedPasswordFromDB)) {
            throw new IllegalArgumentException("Passwords is blank");
        }
        return passwordEncoder.matches(rawPassword, encodedPasswordFromDB);
    }
}
