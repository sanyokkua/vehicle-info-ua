package ua.vehicle.info.processing.jobs;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.processing.processor.Task;

@Slf4j
@RequiredArgsConstructor
public class GetHtmlDocumentTask implements Task<URL, Document> {

    private final RetryPolicy<Object> retryPolicy;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Document process(@NonNull URL input) {
        var url = input.toString();
        try {
            var connection = Jsoup.connect(url)
                    .timeout((int) TimeUnit.MINUTES.toMillis(1));
            return Failsafe.with(retryPolicy)
                    .get(connection::get);
        } catch (Exception e) {
            log.warn("Problem with getting html page by url: {}", url, e);
            return null;
        }
    }
}
