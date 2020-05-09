package ua.vehicle.info.processing.processor.tasks;

import lombok.NonNull;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.processing.processor.Task;

public abstract class AbstractPersistCsvRecordTask<T> implements Task<Iterable<CSVRecord>, Void> {

    @LogInputOutput
    @Override
    public Void process(@NonNull Iterable<CSVRecord> input) {
        for (CSVRecord record : input) {
            T obj = map(record);
            persist(obj);
        }
        return null;
    }

    public abstract T map(CSVRecord input);

    public abstract void persist(T record);
}
