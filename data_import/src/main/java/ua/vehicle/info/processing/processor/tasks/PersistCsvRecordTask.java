package ua.vehicle.info.processing.processor.tasks;

import java.util.Iterator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.processing.mappers.Mapper;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.processing.processor.Task;

@RequiredArgsConstructor
public class PersistCsvRecordTask<T> implements Task<Iterator<CSVRecord>, Void> {

    private final Mapper<CSVRecord, T> mapper;
    private final Persister<T> persister;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Void process(@NonNull Iterator<CSVRecord> input) {
        input.forEachRemaining(record -> {
            T obj = map(record);
            persist(obj);
        });
        return null;
    }

    @SuppressRuntimeExceptions
    @LogExceptions
    private T map(@NonNull CSVRecord input) {
        return mapper.map(input);
    }

    @SuppressRuntimeExceptions
    @LogExceptions
    private void persist(@NonNull T record) {
        persister.persist(record);
    }
}
