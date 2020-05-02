package ua.vehicle.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.processor.tasks.AbstractDownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.AbstractPersistCsvRecordTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;
import ua.vehicle.info.processing.registrations.jobs.DownloadJsonTask;
import ua.vehicle.info.processing.registrations.jobs.DownloadZipArchiveTask;
import ua.vehicle.info.processing.registrations.jobs.ParseUrlsFromJsonTask;
import ua.vehicle.info.processing.registrations.jobs.PersistRegistrationRecordTask;

@Configuration
public class BeansConfiguration {

    @Bean
    public AbstractDownloadFileTask downloadJsonTask() {
        return new DownloadJsonTask();
    }

    @Bean
    public AbstractDownloadFileTask downloadZipArchiveTask() {
        return new DownloadZipArchiveTask();
    }

    @Bean
    public ReadCsvFileTask readCsvFileTask() {
        return new ReadCsvFileTask();
    }

    @Bean
    public UnzipTask unzipTask() {
        return new UnzipTask();
    }

    @Bean
    public ParseUrlsFromJsonTask parseUrlsFromJsonTask() {
        return new ParseUrlsFromJsonTask();
    }

    @Bean
    public AbstractPersistCsvRecordTask<RegistrationRecord> persistRegistrationRecordTask() {
        return new PersistRegistrationRecordTask();
    }
}
