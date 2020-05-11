package ua.vehicle.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.listeners.OnMessageListener;
import ua.vehicle.info.persist.AdminUnitPersistListener;
import ua.vehicle.info.persist.RegistrationPersistListener;
import ua.vehicle.info.persist.ServiceCenterPersistListener;

@Configuration
public class BeansConfig {

    @Bean
    public OnMessageListener<AdminUnitRecord> adminUnitRecordOnMessageListener() {
        return new AdminUnitPersistListener();
    }

    @Bean
    public OnMessageListener<RegistrationRecord> registrationRecordOnMessageListener() {
        return new RegistrationPersistListener();
    }

    @Bean
    public OnMessageListener<ServiceCenterRecord> serviceCenterRecordOnMessageListener() {
        return new ServiceCenterPersistListener();
    }
}
