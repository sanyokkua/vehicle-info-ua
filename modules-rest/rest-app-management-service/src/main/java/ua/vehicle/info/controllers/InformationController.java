package ua.vehicle.info.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.services.ServicesInformationService;

@RestController
@RequiredArgsConstructor
public class InformationController {

    private final ServicesInformationService service;

    @GetMapping("/services")
    public List<String> getAllServices() {
        return service.getAppServices();
    }

    @GetMapping("/services/running")
    public List<String> getAllRunningServices() {
        return service.getRunningAppServices();
    }

}
