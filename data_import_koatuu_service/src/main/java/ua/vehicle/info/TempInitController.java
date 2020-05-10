package ua.vehicle.info;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import ua.vehicle.info.processing.AdminUnitProcessing;

@Controller
@RequiredArgsConstructor
public class TempInitController {

    private final AdminUnitProcessing adminUnitProcessing;

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws MalformedURLException {
        var url = new URL(
                "https://data.gov.ua/dataset/d945de87-539c-45b4-932a-7dda57daf8d9/resource/296adb7a-476a-40c8-9de6-211327cb3aa1/download/koatuu.json");
        adminUnitProcessing.processing(url);
    }
}
