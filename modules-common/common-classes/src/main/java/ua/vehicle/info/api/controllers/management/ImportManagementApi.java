package ua.vehicle.info.api.controllers.management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;

public interface ImportManagementApi {

    String START_PROCESSING = "/process/{serviceName}";
    String PROCESSING_STATUS = "/process/{serviceName}/status";

    @PostMapping(START_PROCESSING)
    ProcessingStatus start(@PathVariable String serviceName);

    @GetMapping(PROCESSING_STATUS)
    ProcessingStatus status(@PathVariable String serviceName);
}
