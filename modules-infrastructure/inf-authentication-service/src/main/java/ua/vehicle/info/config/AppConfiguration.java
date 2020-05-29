package ua.vehicle.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import ua.vehicle.info.utils.PasswordUtils;

/**
 * The type App configuration.
 */
@Configuration
public class AppConfiguration {

    /**
     * Pbkdf 2 password encoder pbkdf 2 password encoder.
     *
     * @return the pbkdf 2 password encoder
     */
    @Bean
    public Pbkdf2PasswordEncoder pbkdf2PasswordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    /**
     * Password utils password utils.
     *
     * @param pbkdf2PasswordEncoder the pbkdf 2 password encoder
     *
     * @return the password utils
     */
    @Bean
    public PasswordUtils passwordUtils(Pbkdf2PasswordEncoder pbkdf2PasswordEncoder) {
        return new PasswordUtils(pbkdf2PasswordEncoder);
    }
}
