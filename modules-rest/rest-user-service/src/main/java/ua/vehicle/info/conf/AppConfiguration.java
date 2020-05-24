package ua.vehicle.info.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableSpringDataWebSupport
@Configuration
public class AppConfiguration {

    @Bean
    public Pbkdf2PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

}
