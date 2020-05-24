package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ImportServiceCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportServiceCenterApplication.class, args);
    }

}
