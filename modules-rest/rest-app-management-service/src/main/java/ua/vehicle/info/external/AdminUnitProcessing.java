package ua.vehicle.info.external;

import org.springframework.cloud.openfeign.FeignClient;
import ua.vehicle.info.api.controllers.processing.ProcessingControllerApi;
import ua.vehicle.info.discovery.ServicesNamesConstants;

/**
 * The interface Admin unit processing.
 */
@FeignClient(ServicesNamesConstants.IMPORT_ADMIN_UNIT_SERVICE)
public interface AdminUnitProcessing extends ProcessingControllerApi {

}
