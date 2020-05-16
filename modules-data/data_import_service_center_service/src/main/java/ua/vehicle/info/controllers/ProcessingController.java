package ua.vehicle.info.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.processing.ServiceCenterProcessing;

@Controller
@RequiredArgsConstructor
public class ProcessingController implements BaseController {

    private final ServiceCenterProcessing serviceCenterProcessing;

    @LogExceptions
    @LogInputOutput
    @PostMapping("/startProcessing")
    @Override
    public void startProcessing() {
        try {
            var url = new URL("http://hsc.gov.ua/kontakti/kontakti-gsts-pidrozdiliv/");
            serviceCenterProcessing.processing(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
