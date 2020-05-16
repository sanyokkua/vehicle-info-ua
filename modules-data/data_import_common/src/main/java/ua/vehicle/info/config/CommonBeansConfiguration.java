package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeansConfiguration {

    @Bean
    public Gson getGson() {
        return new Gson();
    }

}
