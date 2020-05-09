package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.registration.RegistrationRecord;
import ua.vehicle.info.processing.processor.tasks.AbstractDownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.AbstractPersistCsvRecordTask;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;
import ua.vehicle.info.processing.registrations.CsvRecordToRegistrationMapper;
import ua.vehicle.info.processing.registrations.RegistrationPersister;
import ua.vehicle.info.processing.registrations.jobs.DownloadJsonTask;
import ua.vehicle.info.processing.registrations.jobs.DownloadZipArchiveTask;
import ua.vehicle.info.processing.registrations.jobs.GetCsvPathTask;
import ua.vehicle.info.processing.registrations.jobs.ParseUrlsFromJsonTask;
import ua.vehicle.info.processing.registrations.jobs.PersistRegistrationRecordTask;
import ua.vehicle.info.services.FileUtilsService;

@Configuration
public class BeansConfiguration {

    @Bean
    public AbstractDownloadFileTask downloadJsonTask(FileUtilsService fileUtilsService) {
        return new DownloadJsonTask(fileUtilsService);
    }

    @Bean
    public AbstractDownloadFileTask downloadZipArchiveTask(FileUtilsService fileUtilsService) {
        return new DownloadZipArchiveTask(fileUtilsService);
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
    public AbstractPersistCsvRecordTask<RegistrationRecord> persistRegistrationRecordTask(
            CsvRecordToRegistrationMapper csvRecordToRegistrationMapper,
            RegistrationPersister registrationPersister) {
        return new PersistRegistrationRecordTask(csvRecordToRegistrationMapper, registrationPersister);
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
    public Gson getGson() {
        return new Gson();
    }

    @Bean
    public CsvRecordToRegistrationMapper csvRecordToRegistrationMapper(Gson gson) {
        return new CsvRecordToRegistrationMapper(gson);
    }

    @Bean
    public RegistrationPersister registrationPersister() {
        return new RegistrationPersister();
    }
}
