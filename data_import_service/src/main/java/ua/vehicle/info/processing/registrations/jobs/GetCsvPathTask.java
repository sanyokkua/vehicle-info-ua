package ua.vehicle.info.processing.registrations.jobs;

import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.util.Assert;
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.processing.processor.Task;

public class GetCsvPathTask implements Task<Path, Path> {

    @LogInputOutput
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
