package ua.vehicle.info.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.processing.RegistrationProcessing;

@Controller
@RequiredArgsConstructor
public class ProcessingController implements BaseController {

    private final RegistrationProcessing registrationProcessing;

    @LogExceptions
    @LogInputOutput
    @PostMapping("/startProcessing")
    @Override
    public void startProcessing() {
        try {
            var url = new URL("https://data.gov.ua/dataset/06779371-308f-42d7-895e-5a39833375f0/datapackage");
            registrationProcessing.processing(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
