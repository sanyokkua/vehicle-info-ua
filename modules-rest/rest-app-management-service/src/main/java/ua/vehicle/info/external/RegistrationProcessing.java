package ua.vehicle.info.external;

import org.springframework.cloud.openfeign.FeignClient;
import ua.vehicle.info.api.controllers.ProcessingControllerApi;
import ua.vehicle.info.discovery.ServicesNamesConstants;

@FeignClient(ServicesNamesConstants.IMPORT_REGISTRATION_SERVICE)
public interface RegistrationProcessing extends ProcessingControllerApi {

}
