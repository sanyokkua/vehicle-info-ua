package ua.vehicle.info.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.processing.ServiceCenterProcessing;

/**
 * The type Processing controller.
 */
@RestController
@RequiredArgsConstructor
public class ProcessingController extends AbstractProcessingController {

    private final ServiceCenterProcessing serviceCenterProcessing;
    @Value("${service.center.url}")
    private String serviceCenterUrl;

    @LogExceptions
    @LogInputOutput
    @PostMapping(START)
    @Override
    public ProcessingStatus startProcessing() {
        serviceCenterProcessing.setListener(super.eventListener);
        try {
            var url = new URL(this.serviceCenterUrl);
            return start(() -> serviceCenterProcessing.processing(url));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @LogExceptions
    @LogInputOutput
    @GetMapping(STATUS)
    public ProcessingStatus getStatus() {
        return buildStatus();
    }

}
