package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.CsvRecordToRegistrationInputMapper;
import ua.vehicle.info.processing.RegistrationPersister;
import ua.vehicle.info.processing.jobs.GetCsvPathTask;
import ua.vehicle.info.processing.jobs.ParseUrlsFromJsonTask;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.DownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;
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
     * Read csv file task read csv file task.
     *
     * @param fileUtilsService the file utils service
     *
     * @return the read csv file task
     */
    @Bean
    public ReadCsvFileTask readCsvFileTask(FileUtilsService fileUtilsService) {
        return new ReadCsvFileTask(fileUtilsService);
    }

    /**
     * Unzip task unzip task.
     *
     * @param fileUtilsService the file utils service
     *
     * @return the unzip task
     */
    @Bean
    public UnzipTask unzipTask(FileUtilsService fileUtilsService) {
        return new UnzipTask(fileUtilsService);
    }

    /**
     * Parse urls from json task parse urls from json task.
     *
     * @param gson the gson
     * @param fileUtilsService the file utils service
     *
     * @return the parse urls from json task
     */
    @Bean
    public ParseUrlsFromJsonTask parseUrlsFromJsonTask(Gson gson, FileUtilsService fileUtilsService) {
        return new ParseUrlsFromJsonTask(gson, fileUtilsService);
    }

    /**
     * Persist registration record task persist record task.
     *
     * @param csvRecordToRegistrationMapper the csv record to registration mapper
     * @param registrationPersister the registration persister
     *
     * @return the persist record task
     */
    @Bean
    public PersistRecordTask<CSVRecord, RegistrationRecord> persistRegistrationRecordTask(
            CsvRecordToRegistrationInputMapper csvRecordToRegistrationMapper,
            RegistrationPersister registrationPersister) {
        return new PersistRecordTask<>(csvRecordToRegistrationMapper, registrationPersister);
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

    /**
     * Gets csv path task.
     *
     * @return the csv path task
     */
    @Bean
    public GetCsvPathTask getCsvPathTask() {
        return new GetCsvPathTask();
    }

    /**
     * Csv record to registration mapper csv record to registration input mapper.
     *
     * @param gson the gson
     *
     * @return the csv record to registration input mapper
     */
    @Bean
    public CsvRecordToRegistrationInputMapper csvRecordToRegistrationMapper(Gson gson) {
        return new CsvRecordToRegistrationInputMapper(gson);
    }

    /**
     * Registration persister registration persister.
     *
     * @param queueSenderService the queue sender service
     *
     * @return the registration persister
     */
    @Bean
    public RegistrationPersister registrationPersister(QueueSenderService queueSenderService) {
        return new RegistrationPersister(queueSenderService);
    }
}
