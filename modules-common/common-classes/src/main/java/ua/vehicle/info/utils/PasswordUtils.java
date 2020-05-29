package ua.vehicle.info.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * The type Password utils.
 */
@Slf4j
@RequiredArgsConstructor
public class PasswordUtils {

    /**
     * The Password encoder.
     */
    protected final Pbkdf2PasswordEncoder passwordEncoder;

    /**
     * Encode string.
     *
     * @param rawPassword the raw password
     *
     * @return the string
     */
    public String encode(@NonNull String rawPassword) {
        if (StringUtils.isBlank(rawPassword)) {
            throw new IllegalArgumentException("Password is blank");
        }
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Is matching boolean.
     *
     * @param rawPassword the raw password
     * @param encodedPasswordFromDB the encoded password from db
     *
     * @return the boolean
     */
    public boolean isMatching(@NonNull String rawPassword, @NonNull String encodedPasswordFromDB) {
        if (StringUtils.isBlank(rawPassword) || StringUtils.isBlank(encodedPasswordFromDB)) {
            throw new IllegalArgumentException("Passwords is blank");
        }
        return passwordEncoder.matches(rawPassword, encodedPasswordFromDB);
    }
}
