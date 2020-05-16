package ua.vehicle.info.processing.processor.tasks;

import java.util.Iterator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.processing.mappers.InputMapper;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.processing.processor.Task;

@RequiredArgsConstructor
public class PersistRecordTask<I, T> implements Task<Iterator<I>, Void> {

    private final InputMapper<I, T> inputMapper;
    private final Persister<T> persister;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Void process(@NonNull Iterator<I> input) {
        input.forEachRemaining(record -> {
            T obj = map(record);
            persist(obj);
        });
        return null;
    }

    @SuppressRuntimeExceptions
    @LogExceptions
    private T map(@NonNull I input) {
        return inputMapper.map(input);
    }

    @SuppressRuntimeExceptions
    @LogExceptions
    private void persist(@NonNull T record) {
        persister.persist(record);
    }
}
