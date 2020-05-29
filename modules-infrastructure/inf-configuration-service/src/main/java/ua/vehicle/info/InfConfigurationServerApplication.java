package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The type Inf configuration server application.
 */
@EnableConfigServer
@SpringBootApplication
public class InfConfigurationServerApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(InfConfigurationServerApplication.class, args);
    }

}
