package ua.vehicle.info.processing.jobs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.processing.processor.Task;

/**
 * The type Parse records task.
 */
@Slf4j
@RequiredArgsConstructor
public class ParseRecordsTask implements Task<Path, Iterator<AdminUnitRecord>> {

    private static final Type LIST_TYPE = new TypeToken<List<AdminUnitRecord>>() {

    }.getType();
    private final Gson gson;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Iterator<AdminUnitRecord> process(Path input) {
        var text = getText(input);
        List<AdminUnitRecord> pojo = gson.fromJson(text, LIST_TYPE);
        if (Objects.isNull(pojo)) {
            return Collections.emptyIterator();
        }
        return pojo.iterator();
    }

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    private String getText(Path input) {
        try {
            var bytes = Files.readAllBytes(input);
            return new String(bytes);
        } catch (IOException e) {
            log.warn("Problem with reading file: {}", input.toAbsolutePath().toString());
            return null;
        }
    }
}
