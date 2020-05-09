package ua.vehicle.info.processing.processor.tasks;

import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

@Slf4j
@RequiredArgsConstructor
public class UnzipTask implements Task<Path, Path> {

    protected final FileUtilsService fileUtilsService;

    @LogInputOutput
    @Override
    public Path process(@NonNull Path input) {
        try {
            var inputFilePath = input.toString();
            var fileName = FilenameUtils.getBaseName(inputFilePath);
            var outputDirectory = fileUtilsService.getTempDirectory().toAbsolutePath();
            var destination = Paths.get(outputDirectory.toString(), fileName);

            var zipFile = new ZipFile(input.toFile());
            zipFile.extractAll(destination.toAbsolutePath().toString());

            return destination;
        } catch (ZipException e) {
            log.error("extractZipArchive: Error occurred with extracting files from zip archive", e);
            return null;
        }
    }
}
