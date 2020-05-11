package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.CsvRecordToRegistrationMapper;
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

@Configuration
public class BeansConfiguration {

    @Bean
    public DownloadFileTask downloadFileTask(FileUtilsService fileUtilsService) {
        return new DownloadFileTask(fileUtilsService);
    }

    @Bean
    public ReadCsvFileTask readCsvFileTask(FileUtilsService fileUtilsService) {
        return new ReadCsvFileTask(fileUtilsService);
    }

    @Bean
    public UnzipTask unzipTask(FileUtilsService fileUtilsService) {
        return new UnzipTask(fileUtilsService);
    }

    @Bean
    public ParseUrlsFromJsonTask parseUrlsFromJsonTask(Gson gson, FileUtilsService fileUtilsService) {
        return new ParseUrlsFromJsonTask(gson, fileUtilsService);
    }

    @Bean
    public PersistRecordTask<CSVRecord, RegistrationRecord> persistRegistrationRecordTask(
            CsvRecordToRegistrationMapper csvRecordToRegistrationMapper,
            RegistrationPersister registrationPersister) {
        return new PersistRecordTask<>(csvRecordToRegistrationMapper, registrationPersister);
    }

    @Bean
    public DeleteFilesTask deleteFilesTask() {
        return new DeleteFilesTask();
    }

    @Bean
    public GetCsvPathTask getCsvPathTask() {
        return new GetCsvPathTask();
    }


    @Bean
    public CsvRecordToRegistrationMapper csvRecordToRegistrationMapper(Gson gson) {
        return new CsvRecordToRegistrationMapper(gson);
    }

    @Bean
    public RegistrationPersister registrationPersister(QueueSenderService queueSenderService) {
        return new RegistrationPersister(queueSenderService);
    }
}
