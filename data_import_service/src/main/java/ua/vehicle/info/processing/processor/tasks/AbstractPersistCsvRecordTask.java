package ua.vehicle.info.processing.processor.tasks;

import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.processing.processor.Task;

public abstract class AbstractPersistCsvRecordTask<T> implements Task<Iterable<CSVRecord>, Void> {

    @Override
    public Void process(Iterable<CSVRecord> input) {
        return null;
    }

    public abstract T map(CSVRecord input);

    public abstract boolean persist(T record);
}
