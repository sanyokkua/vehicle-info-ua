package ua.vehicle.info.processing.jobs;

import lombok.NonNull;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.processing.processor.Task;

public class GetHtmlElementWithListTask implements Task<Document, Elements> {

    private static final String SELECTOR =
            "#post-54 > div > div.mapua_form.mapua_region_body > table > tbody > tr.region_item";

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Elements process(@NonNull Document input) {
        return input.select(SELECTOR);
    }
}
