package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The type Import admin unit application.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ImportAdminUnitApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ImportAdminUnitApplication.class, args);
    }

}
