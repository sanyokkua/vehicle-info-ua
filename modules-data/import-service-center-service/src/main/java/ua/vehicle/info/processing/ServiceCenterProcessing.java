package ua.vehicle.info.processing;

import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.processing.jobs.GetHtmlDocumentTask;
import ua.vehicle.info.processing.jobs.GetHtmlElementWithListTask;
import ua.vehicle.info.processing.jobs.ParseServiceCentersTask;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;

@Component
@RequiredArgsConstructor
public class ServiceCenterProcessing extends Processor {

    private final GetHtmlDocumentTask step1GetHtmlDocument;
    private final GetHtmlElementWithListTask step2GetHtmlElement;
    private final ParseServiceCentersTask step3parseServiceCenters;
    private final PersistRecordTask<ServiceCenterRecord, ServiceCenterRecord> step4PersistServiceCenters;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public void runSteps(URL url) {
        var document = step1GetHtmlDocument.process(url);
        var elements = step2GetHtmlElement.process(document);
        var parsedServiceCenters = step3parseServiceCenters.process(elements);
        step4PersistServiceCenters.process(parsedServiceCenters);
    }
}
