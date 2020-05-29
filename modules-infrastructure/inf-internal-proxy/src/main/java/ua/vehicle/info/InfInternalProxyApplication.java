package ua.vehicle.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * The type Inf internal proxy application.
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class InfInternalProxyApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(InfInternalProxyApplication.class, args);
    }

}
