package ua.vehicle.info.api.controllers.management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;

/**
 * The interface Import management api.
 * It is used in app-management service to controller
 * and check status of processing services.
 */
public interface ImportManagementApi {

    /**
     * Represents start processing request path
     */
    String START_PROCESSING = "/process/{serviceName}";
    /**
     * Represents processing status request path
     */
    String PROCESSING_STATUS = "/process/{serviceName}/status";

    /**
     * This endpoint will start processing of data for given serviceName
     *
     * @param serviceName the service name
     *
     * @return the processing status
     */
    @PostMapping(START_PROCESSING)
    ProcessingStatus start(@PathVariable String serviceName);

    /**
     * This endpoint will return status of processing for given name
     *
     * @param serviceName the service name
     *
     * @return the processing status
     */
    @GetMapping(PROCESSING_STATUS)
    ProcessingStatus status(@PathVariable String serviceName);
}
