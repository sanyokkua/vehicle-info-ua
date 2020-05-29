package ua.vehicle.info.processing.jobs;

import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.util.Assert;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.processing.processor.Task;

/**
 * The type Get csv path task.
 */
public class GetCsvPathTask implements Task<Path, Path> {

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Path process(Path input) {
        var listFiles = input.toFile().listFiles();
        Assert.notNull(listFiles, "List of files in destination directory is null");
        return Stream.of(listFiles)
                .map(File::toPath)
                .findFirst()
                .orElse(null);
    }
}
