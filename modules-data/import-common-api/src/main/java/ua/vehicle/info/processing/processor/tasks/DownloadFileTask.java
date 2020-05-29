package ua.vehicle.info.processing.processor.tasks;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

/**
 * The type Download file task.
 */
@Slf4j
@RequiredArgsConstructor
public class DownloadFileTask implements Task<URL, Path> {

    /**
     * The File utils service.
     */
    protected final FileUtilsService fileUtilsService;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Path process(@NonNull URL input) {
        var tmpDir = fileUtilsService.getTempDirectory();
        if (Objects.isNull(tmpDir)) {
            return null;
        }
        return processDownload(input, tmpDir);
    }

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    private Path processDownload(@NonNull URL url, @NonNull Path tmpDir) {
        try {
            var fileName = FilenameUtils.getName(url.getPath());
            var targetPath = Paths.get(tmpDir.toAbsolutePath().toString(), fileName);
            try (var in = url.openStream()) {
                Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
            return targetPath;
        } catch (Exception e) {
            log.warn("Exception occurred. Problem with downloading file");
            return null;
        }
    }

}
