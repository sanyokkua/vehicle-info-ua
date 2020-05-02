package ua.vehicle.info.processing.processor.tasks;

import java.nio.file.Path;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.processing.processor.Task;

public class ReadCsvFileTask implements Task<Path, Iterable<CSVRecord>> {

    @Override
    public Iterable<CSVRecord> process(Path input) {
        return null;
    }
}
