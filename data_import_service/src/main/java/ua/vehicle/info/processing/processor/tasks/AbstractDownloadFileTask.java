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
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractDownloadFileTask implements Task<String, Path> {

    protected final FileUtilsService fileUtilsService;

    @LogInputOutput
    @Override
    public Path process(@NonNull String input) {
        var tmpDir = fileUtilsService.getTempDirectory();
        if (Objects.isNull(tmpDir)) {
            return null;
        }
        return processDownload(input, tmpDir);
    }

    @LogInputOutput
    private Path processDownload(@NonNull String input, Path tmpDir) {
        try {
            var url = new URL(input);
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
