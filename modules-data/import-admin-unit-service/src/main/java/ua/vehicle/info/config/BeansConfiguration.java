package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.processing.AdminUnitPersister;
import ua.vehicle.info.processing.jobs.ParseRecordsTask;
import ua.vehicle.info.processing.mappers.InputMapper;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.DownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;
import ua.vehicle.info.queues.sender.QueueSenderService;
import ua.vehicle.info.services.FileUtilsService;

/**
 * The type Beans configuration.
 */
@Configuration
public class BeansConfiguration {

    /**
     * Download file task download file task.
     *
     * @param fileUtilsService the file utils service
     *
     * @return the download file task
     */
    @Bean
    public DownloadFileTask downloadFileTask(FileUtilsService fileUtilsService) {
        return new DownloadFileTask(fileUtilsService);
    }

    /**
     * Parse records task parse records task.
     *
     * @param gson the gson
     *
     * @return the parse records task
     */
    @Bean
    public ParseRecordsTask parseRecordsTask(Gson gson) {
        return new ParseRecordsTask(gson);
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
    public PersistRecordTask<AdminUnitRecord, AdminUnitRecord> persistRecordTask(
            InputMapper<AdminUnitRecord, AdminUnitRecord> inputMapper,
            Persister<AdminUnitRecord> persister) {
        return new PersistRecordTask<>(inputMapper, persister);
    }

    /**
     * Mapper input mapper.
     *
     * @return the input mapper
     */
    @Bean
    public InputMapper<AdminUnitRecord, AdminUnitRecord> mapper() {
        return unit -> unit;
    }

    /**
     * Persister persister.
     *
     * @param queueSenderService the queue sender service
     *
     * @return the persister
     */
    @Bean
    public Persister<AdminUnitRecord> persister(QueueSenderService queueSenderService) {
        return new AdminUnitPersister(queueSenderService);
    }

    /**
     * Delete files task delete files task.
     *
     * @return the delete files task
     */
    @Bean
    public DeleteFilesTask deleteFilesTask() {
        return new DeleteFilesTask();
    }
}
