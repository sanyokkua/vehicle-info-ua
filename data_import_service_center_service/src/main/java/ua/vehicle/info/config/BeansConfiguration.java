package ua.vehicle.info.config;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.time.temporal.ChronoUnit;
import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.RetryPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.processing.ServiceCenterPersister;
import ua.vehicle.info.processing.jobs.GetHtmlDocumentTask;
import ua.vehicle.info.processing.jobs.GetHtmlElementWithListTask;
import ua.vehicle.info.processing.jobs.ParseServiceCentersTask;
import ua.vehicle.info.processing.mappers.Mapper;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;
import ua.vehicle.info.queues.sender.QueueSenderService;

@Slf4j
@Configuration
public class BeansConfiguration {

    @Bean
    public RetryPolicy<Object> retryPolicy() {
        return new RetryPolicy<>()
                .handle(ConnectException.class)
                .handle(SocketTimeoutException.class)
                .withMaxRetries(10)
                .withBackoff(1, 20, ChronoUnit.MINUTES)
                .onFailedAttempt(a -> log.warn("Failed attempt {}", a.getAttemptCount(), a.getLastFailure()))
                .onRetry(r -> log.info("Retry N:{}", r.getAttemptCount()))
                .onRetriesExceeded(e -> log.warn("Failed to connect. Max retries exceeded."))
                .onAbort(e -> log.warn("Connection aborted due to {}.", e.getFailure().toString(), e.getFailure()));
    }

    @Bean
    public GetHtmlDocumentTask getHtmlDocument(RetryPolicy<Object> retryPolicy) {
        return new GetHtmlDocumentTask(retryPolicy);
    }

    @Bean
    public GetHtmlElementWithListTask getHtmlElementWithList() {
        return new GetHtmlElementWithListTask();
    }

    @Bean
    public ParseServiceCentersTask parseServiceCenters() {
        return new ParseServiceCentersTask();
    }

    @Bean
    public PersistRecordTask<ServiceCenterRecord, ServiceCenterRecord> persistRecordTask(
            Mapper<ServiceCenterRecord, ServiceCenterRecord> mapper,
            Persister<ServiceCenterRecord> persister) {
        return new PersistRecordTask<>(mapper, persister);
    }

    @Bean
    public Mapper<ServiceCenterRecord, ServiceCenterRecord> mapper() {
        return serviceCenter -> serviceCenter;
    }

    @Bean
    public Persister<ServiceCenterRecord> persister(QueueSenderService queueSenderService) {
        return new ServiceCenterPersister(queueSenderService);
    }

}
