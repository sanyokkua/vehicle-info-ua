package ua.vehicle.info.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.processing.AdminUnitProcessing;

@Controller
@RequiredArgsConstructor
public class ProcessingController implements BaseController {

    private final AdminUnitProcessing adminUnitProcessing;

    @LogExceptions
    @LogInputOutput
    @PostMapping("/startProcessing")
    @Override
    public void startProcessing() {
        try {
            var url =
                    new URL("https://data.gov.ua/dataset/d945de87-539c-45b4-932a-7dda57daf8d9/resource/296adb7a-476a-40c8-9de6-211327cb3aa1/download/koatuu.json");
            adminUnitProcessing.processing(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
