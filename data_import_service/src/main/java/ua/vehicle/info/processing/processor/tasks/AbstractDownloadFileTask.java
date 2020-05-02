package ua.vehicle.info.processing.processor.tasks;

import java.nio.file.Path;
import ua.vehicle.info.processing.processor.Task;

public abstract class AbstractDownloadFileTask implements Task<String, Path> {

    @Override
    public Path process(String input) {
        return null;
    }
}
