package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InfDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfDiscoveryServerApplication.class, args);
    }

}
