package ua.vehicle.info;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import ua.vehicle.info.processing.ServiceCenterProcessing;

@Controller
@RequiredArgsConstructor
public class TempInitController {

    private final ServiceCenterProcessing serviceCenterProcessing;

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws MalformedURLException {
        var url = new URL("http://hsc.gov.ua/kontakti/kontakti-gsts-pidrozdiliv/");
        serviceCenterProcessing.processing(url);
    }
}
