package ua.vehicle.info.processing.processor.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.processing.processor.Task;

@Slf4j
public class DeleteFilesTask implements Task<List<Path>, Void> {

    @LogInputOutput
    @Override
    public Void process(List<Path> input) {
        input.stream()
                .filter(Files::exists)
                .forEach(file -> {
                    try {
                        Files.delete(file);
                    } catch (IOException e) {
                        log.warn("Problem with removing of :" + file.toString(), e);
                    }
                });
        return null;
    }
}
