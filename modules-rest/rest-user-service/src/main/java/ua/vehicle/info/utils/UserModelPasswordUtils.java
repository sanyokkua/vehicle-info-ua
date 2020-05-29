package ua.vehicle.info.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.vehicle.info.model.UserModel;

/**
 * The type User model password utils.
 */
@Slf4j
@Component
public class UserModelPasswordUtils extends PasswordUtils {

    /**
     * Instantiates a new User model password utils.
     *
     * @param passwordEncoder the password encoder
     */
    @Autowired
    public UserModelPasswordUtils(Pbkdf2PasswordEncoder passwordEncoder) {
        super(passwordEncoder);
    }

    /**
     * Encrypt user model.
     *
     * @param userModel the user model
     *
     * @return the user model
     */
    public UserModel encrypt(UserModel userModel) {
        log.info("Password will be encrypted");
        var password = userModel.getPassword();
        var encoded = encode(password);
        log.debug("Encoded password {}", encoded);
        return UserModel.builder()
                .email(userModel.getEmail())
                .password(encoded)
                .username(userModel.getUsername())
                .build();

    }
}
