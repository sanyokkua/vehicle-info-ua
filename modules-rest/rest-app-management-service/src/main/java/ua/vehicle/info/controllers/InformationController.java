package ua.vehicle.info.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.controllers.management.ServicesStatusApi;
import ua.vehicle.info.services.ServicesInformationService;

@RestController
@RequiredArgsConstructor
public class InformationController implements ServicesStatusApi {

    private final ServicesInformationService service;

    @GetMapping(SERVICES_LIST)
    @Override
    public List<String> getAllServices() {
        return service.getAppServices();
    }

    @GetMapping(RUNNING_SERVICES_LIST)
    @Override
    public List<String> getAllRunningServices() {
        return service.getRunningAppServices();
    }

}
