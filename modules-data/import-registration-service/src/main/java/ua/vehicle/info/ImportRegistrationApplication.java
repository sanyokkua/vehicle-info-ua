package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ImportRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportRegistrationApplication.class, args);
    }

}
