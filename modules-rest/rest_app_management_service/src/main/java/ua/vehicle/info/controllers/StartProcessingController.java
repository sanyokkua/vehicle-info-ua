package ua.vehicle.info.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.services.ServicesInformationService;
import ua.vehicle.info.services.StartProcessingService;

@RestController
@RequiredArgsConstructor
public class StartProcessingController {

    private final StartProcessingService processingService;
    private final ServicesInformationService informationService;

    @PostMapping("/process/{serviceName}")
    public String start(@PathVariable String serviceName) {
        processingService.startService(serviceName);
        return "200 Ok";
    }
}
