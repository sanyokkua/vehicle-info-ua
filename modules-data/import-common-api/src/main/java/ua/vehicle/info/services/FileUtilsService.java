package ua.vehicle.info.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;

@Service
@Slf4j
public class FileUtilsService {

    private static final String SYSTEM_TMP_FOLDER_PROPERTY = "java.io.tmpdir";
    private static final String APP_TMP_FOLDER = "vehicle_tmp";

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    public Path getTempDirectory() {
        var tmpFolder = System.getProperty(SYSTEM_TMP_FOLDER_PROPERTY);
        var tmpFolderPath = Paths.get(tmpFolder, APP_TMP_FOLDER);
        if (Files.exists(tmpFolderPath) && Files.isDirectory(tmpFolderPath)) {
            return tmpFolderPath;
        }
        try {
            Files.createDirectory(tmpFolderPath);
            return tmpFolderPath;
        } catch (IOException e) {
            log.warn("getTempDirectory: Was the problem with creating temp directory");
            return null;
        }
    }

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    public String getEncoding(@NonNull Path textFile) {
        try {
            log.debug("getEncoding: Trying to distinguish encoding of file: {}", textFile);
            return UniversalDetector.detectCharset(textFile);
        } catch (IOException e) {
            log.error("getEncoding: Exception occurred due encoding detecting", e);
            return "UTF-8";
        }
    }
}
