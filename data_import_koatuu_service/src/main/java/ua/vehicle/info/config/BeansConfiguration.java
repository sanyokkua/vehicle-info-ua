package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.processing.AdminUnitPersister;
import ua.vehicle.info.processing.jobs.ParseRecordsTask;
import ua.vehicle.info.processing.mappers.Mapper;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.DownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;
import ua.vehicle.info.services.FileUtilsService;

@Configuration
public class BeansConfiguration {

    @Bean
    public DownloadFileTask downloadFileTask(FileUtilsService fileUtilsService) {
        return new DownloadFileTask(fileUtilsService);
    }

    @Bean
    public ParseRecordsTask parseRecordsTask(Gson gson) {
        return new ParseRecordsTask(gson);
    }

    @Bean
    public PersistRecordTask<AdminUnitRecord, AdminUnitRecord> persistRecordTask(
            Mapper<AdminUnitRecord, AdminUnitRecord> mapper,
            Persister<AdminUnitRecord> persister) {
        return new PersistRecordTask<>(mapper, persister);
    }

    @Bean
    public Mapper<AdminUnitRecord, AdminUnitRecord> mapper() {
        return unit -> unit;
    }

    @Bean
    public Persister<AdminUnitRecord> persister() {
        return new AdminUnitPersister();
    }

    @Bean
    public DeleteFilesTask deleteFilesTask() {
        return new DeleteFilesTask();
    }

    @Bean
    public Gson getGson() {
        return new Gson();
    }
}
