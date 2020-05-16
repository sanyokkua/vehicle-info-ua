package ua.vehicle.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.listeners.AdminUnitPersistListener;
import ua.vehicle.info.listeners.OnMessageListener;
import ua.vehicle.info.listeners.RegistrationPersistListener;
import ua.vehicle.info.listeners.ServiceCenterPersistListener;
import ua.vehicle.info.mappers.registration.AdminUnitDtoMapper;
import ua.vehicle.info.mappers.registration.ServiceCenterDtoMapper;
import ua.vehicle.info.persist.ServiceCenterService;
import ua.vehicle.info.persist.chain.adminunit.SaveAdminUnitWithLev1Handler;
import ua.vehicle.info.persist.chain.adminunit.SaveAdminUnitWithLev2Handler;
import ua.vehicle.info.persist.chain.adminunit.SaveAdminUnitWithLev3Handler;
import ua.vehicle.info.persist.chain.adminunit.SaveAdminUnitWithLev4Handler;
import ua.vehicle.info.persist.chain.registration.DepartmentDtoHandler;
import ua.vehicle.info.persist.chain.registration.OperationDtoHandler;
import ua.vehicle.info.persist.chain.registration.PurposeDtoHandler;
import ua.vehicle.info.persist.chain.registration.RegistrationDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.BodyTypeDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.BrandDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.ColorDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.FuelTypeDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.KindDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.ModelDtoHandler;
import ua.vehicle.info.persist.chain.vehicle.VehicleDtoHandler;

@Configuration
public class BeansConfig {

    @Bean
    public OnMessageListener<AdminUnitRecord> adminUnitRecordOnMessageListener(AdminUnitDtoMapper mapper,
            SaveAdminUnitWithLev1Handler lev1Handler,
            SaveAdminUnitWithLev2Handler lev2Handler,
            SaveAdminUnitWithLev3Handler lev3Handler,
            SaveAdminUnitWithLev4Handler lev4Handler) {
        lev4Handler.setNext(lev3Handler)
                .setNext(lev2Handler)
                .setNext(lev1Handler);
        return new AdminUnitPersistListener(mapper, lev4Handler);
    }

    @Bean
    public OnMessageListener<ServiceCenterRecord> serviceCenterRecordOnMessageListener(ServiceCenterDtoMapper mapper,
            ServiceCenterService service) {
        return new ServiceCenterPersistListener(mapper, service);
    }

    @Bean
    public OnMessageListener<RegistrationRecord> registrationRecordOnMessageListener(
            BodyTypeDtoHandler bodyTypeDtoHandler,
            BrandDtoHandler brandDtoHandler,
            ColorDtoHandler colorDtoHandler,
            FuelTypeDtoHandler fuelTypeDtoHandler,
            KindDtoHandler kindDtoHandler,
            ModelDtoHandler modelDtoHandler,
            VehicleDtoHandler vehicleDtoHandler,
            DepartmentDtoHandler departmentDtoHandler,
            OperationDtoHandler operationDtoHandler,
            PurposeDtoHandler purposeDtoHandler,
            RegistrationDtoHandler registrationDtoHandler) {
        bodyTypeDtoHandler.setNext(brandDtoHandler)
                .setNext(colorDtoHandler)
                .setNext(fuelTypeDtoHandler)
                .setNext(kindDtoHandler)
                .setNext(modelDtoHandler)
                .setNext(vehicleDtoHandler)
                .setNext(departmentDtoHandler)
                .setNext(operationDtoHandler)
                .setNext(purposeDtoHandler)
                .setNext(registrationDtoHandler);
        return new RegistrationPersistListener(bodyTypeDtoHandler);
    }
}
