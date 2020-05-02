package ua.vehicle.info.processing.registrations.jobs;

import java.nio.file.Path;
import java.util.List;
import ua.vehicle.info.processing.processor.Task;

public class ParseUrlsFromJsonTask implements Task<Path, List<String>> {

    @Override
    public List<String> process(Path input) {
        return null;
    }
}
