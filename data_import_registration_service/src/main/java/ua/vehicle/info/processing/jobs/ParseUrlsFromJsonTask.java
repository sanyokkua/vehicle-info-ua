package ua.vehicle.info.processing.jobs;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.dto.RegistrationDataPackage;
import ua.vehicle.info.dto.ResourceDataPackage;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

@Slf4j
@RequiredArgsConstructor
public class ParseUrlsFromJsonTask implements Task<Path, List<URL>> {

    private final Gson gson;
    private final FileUtilsService fileUtilsService;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public List<URL> process(Path input) {
        var jsonText = getTextFromFile(input);
        var pojo = gson.fromJson(jsonText, RegistrationDataPackage.class);
        return Objects.isNull(pojo) ? Collections.emptyList() :
                pojo.getResources().stream()
                        .map(ResourceDataPackage::getPath)
                        .map(this::getUrl)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
    }

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @SuppressRuntimeExceptions
    private URL getUrl(@NonNull String urlString) {
        try {
            return new URL(urlString);
        } catch (MalformedURLException e) {
            log.warn("Url for string {} can't be created", urlString);
            return null;
        }
    }

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    private String getTextFromFile(@NonNull Path path) {
        if (Files.exists(path)) {
            var encoding = fileUtilsService.getEncoding(path);
            try {
                return FileUtils.readFileToString(path.toFile(), encoding);
            } catch (IOException e) {
                log.error("getTextFromFile: Problem with reading path: " + path.toString() +
                        " with encoding: " + encoding);
                return null;
            }
        }
        return null;
    }
}
