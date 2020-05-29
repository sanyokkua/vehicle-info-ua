package ua.vehicle.info.api.controllers.processing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;

/**
 * The interface Processing controller api.
 * This interface is used as a base for processing
 * services.
 */
public interface ProcessingControllerApi {

    /**
     * Represents start processing request path
     */
    String START = "/startProcessing";
    /**
     * Represents processing status request path
     */
    String STATUS = "/status";

    /**
     * Start processing processing status.
     * Invoke processing of data in service
     *
     * @return the processing status
     */
    @PostMapping(START)
    ProcessingStatus startProcessing();

    /**
     * Gets status.
     * Returns status of current processing execution.
     *
     * @return the processing status
     */
    @GetMapping(STATUS)
    ProcessingStatus getStatus();

}
