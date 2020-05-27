package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class InfConfigurationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfConfigurationServerApplication.class, args);
    }

}
