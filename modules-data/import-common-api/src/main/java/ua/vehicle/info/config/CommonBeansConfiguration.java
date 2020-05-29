package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Common beans configuration.
 */
@Configuration
public class CommonBeansConfiguration {

    /**
     * Gets gson.
     *
     * @return the gson
     */
    @Bean
    public Gson getGson() {
        return new Gson();
    }

}
