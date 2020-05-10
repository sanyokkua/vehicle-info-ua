package ua.vehicle.info.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.DownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;
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
    public DeleteFilesTask deleteFilesTask() {
        return new DeleteFilesTask();
    }

    @Bean
    public Gson getGson() {
        return new Gson();
    }
}
