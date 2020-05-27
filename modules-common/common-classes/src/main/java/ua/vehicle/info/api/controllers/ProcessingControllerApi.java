package ua.vehicle.info.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;

public interface ProcessingControllerApi {

    String START = "/startProcessing";
    String STATUS = "/status";

    @PostMapping(START)
    ProcessingStatus startProcessing();

    @GetMapping(STATUS)
    ProcessingStatus getStatus();

}
