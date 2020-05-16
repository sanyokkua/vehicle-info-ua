package ua.vehicle.info;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import ua.vehicle.info.processing.RegistrationProcessing;

@Controller
@RequiredArgsConstructor
public class TempInitController {

    private final RegistrationProcessing registrationProcessing;

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws MalformedURLException {
        var url = new URL("https://data.gov.ua/dataset/06779371-308f-42d7-895e-5a39833375f0/datapackage");
        registrationProcessing.processing(url);
    }
}
