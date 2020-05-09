package ua.vehicle.info.processing.registrations.jobs;

import ua.vehicle.info.processing.processor.tasks.AbstractDownloadFileTask;
import ua.vehicle.info.services.FileUtilsService;

public class DownloadZipArchiveTask extends AbstractDownloadFileTask {

    public DownloadZipArchiveTask(FileUtilsService fileUtilsService) {
        super(fileUtilsService);
    }
}
