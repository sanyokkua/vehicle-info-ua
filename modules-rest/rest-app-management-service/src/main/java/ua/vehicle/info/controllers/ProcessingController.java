package ua.vehicle.info.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.dto.ProcessingStatus;
import ua.vehicle.info.services.ProcessingService;

@RestController
@RequiredArgsConstructor
public class ProcessingController {

    private final ProcessingService processingService;

    @PostMapping("/process/{serviceName}")
    public ProcessingStatus start(@PathVariable String serviceName) {
        return processingService.startService(serviceName);
    }

    @GetMapping("/process/{serviceName}/status")
    public ProcessingStatus status(@PathVariable String serviceName) {
        return processingService.getStatus(serviceName);
    }
}
