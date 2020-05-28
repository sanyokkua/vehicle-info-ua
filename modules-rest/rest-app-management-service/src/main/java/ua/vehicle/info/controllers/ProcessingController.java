package ua.vehicle.info.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.controllers.management.ImportManagementApi;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;
import ua.vehicle.info.services.ProcessingService;

@RestController
@RequiredArgsConstructor
public class ProcessingController implements ImportManagementApi {

    private final ProcessingService processingService;

    @PostMapping(START_PROCESSING)
    @Override
    public ProcessingStatus start(@PathVariable String serviceName) {
        return processingService.startService(serviceName);
    }

    @GetMapping(PROCESSING_STATUS)
    @Override
    public ProcessingStatus status(@PathVariable String serviceName) {
        return processingService.getStatus(serviceName);
    }
}
