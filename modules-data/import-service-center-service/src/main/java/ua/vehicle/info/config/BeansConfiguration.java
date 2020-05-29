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
import ua.vehicle.info.processing.mappers.InputMapper;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Beans configuration.
 */
@Slf4j
@Configuration
public class BeansConfiguration {

    /**
     * Retry policy retry policy.
     *
     * @return the retry policy
     */
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

    /**
     * Gets html document.
     *
     * @param retryPolicy the retry policy
     *
     * @return the html document
     */
    @Bean
    public GetHtmlDocumentTask getHtmlDocument(RetryPolicy<Object> retryPolicy) {
        return new GetHtmlDocumentTask(retryPolicy);
    }

    /**
     * Gets html element with list.
     *
     * @return the html element with list
     */
    @Bean
    public GetHtmlElementWithListTask getHtmlElementWithList() {
        return new GetHtmlElementWithListTask();
    }

    /**
     * Parse service centers parse service centers task.
     *
     * @return the parse service centers task
     */
    @Bean
    public ParseServiceCentersTask parseServiceCenters() {
        return new ParseServiceCentersTask();
    }

    /**
     * Persist record task persist record task.
     *
     * @param inputMapper the input mapper
     * @param persister the persister
     *
     * @return the persist record task
     */
    @Bean
    public PersistRecordTask<ServiceCenterRecord, ServiceCenterRecord> persistRecordTask(
            InputMapper<ServiceCenterRecord, ServiceCenterRecord> inputMapper,
            Persister<ServiceCenterRecord> persister) {
        return new PersistRecordTask<>(inputMapper, persister);
    }

    /**
     * Mapper input mapper.
     *
     * @return the input mapper
     */
    @Bean
    public InputMapper<ServiceCenterRecord, ServiceCenterRecord> mapper() {
        return serviceCenter -> serviceCenter;
    }

    /**
     * Persister persister.
     *
     * @param queueSenderService the queue sender service
     *
     * @return the persister
     */
    @Bean
    public Persister<ServiceCenterRecord> persister(QueueSenderService queueSenderService) {
        return new ServiceCenterPersister(queueSenderService);
    }

}
