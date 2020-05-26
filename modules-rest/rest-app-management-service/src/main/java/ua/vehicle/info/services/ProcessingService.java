package ua.vehicle.info.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.vehicle.info.api.controllers.ProcessingControllerApi;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.discovery.ServicesNamesConstants;
import ua.vehicle.info.dto.ProcessingStatus;
import ua.vehicle.info.external.AdminUnitProcessing;
import ua.vehicle.info.external.RegistrationProcessing;
import ua.vehicle.info.external.ServiceCenterProcessing;

@Service
@RequiredArgsConstructor
public class ProcessingService {

    private final AdminUnitProcessing adminUnitProcessing;
    private final RegistrationProcessing registrationProcessing;
    private final ServiceCenterProcessing serviceCenterProcessing;

    @LogExceptions
    @LogInputOutput
    @SuppressRuntimeExceptions
    public ProcessingStatus startService(@NonNull String serviceName) {
        var service = getServiceByName(serviceName);
        return service.startProcessing();
    }

    public ProcessingStatus getStatus(@NonNull String serviceName) {
        var service = getServiceByName(serviceName);
        return service.getStatus();
    }

    private ProcessingControllerApi getServiceByName(String name) {
        switch (name) {
            case ServicesNamesConstants.IMPORT_ADMIN_UNIT_SERVICE:
                return adminUnitProcessing;
            case ServicesNamesConstants.IMPORT_REGISTRATION_SERVICE:
                return registrationProcessing;
            case ServicesNamesConstants.IMPORT_SERVICE_CENTER_SERVICE:
                return serviceCenterProcessing;
            default:
                throw new IllegalArgumentException("Service is not supported");
        }
    }
}
