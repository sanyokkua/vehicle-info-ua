package ua.vehicle.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import ua.vehicle.info.util.PasswordUtils;

@Configuration
public class AppConfiguration {

    @Bean
    public Pbkdf2PasswordEncoder pbkdf2PasswordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public PasswordUtils passwordUtils(Pbkdf2PasswordEncoder pbkdf2PasswordEncoder) {
        return new PasswordUtils(pbkdf2PasswordEncoder);
    }
}
