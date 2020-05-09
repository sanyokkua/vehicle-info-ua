package ua.vehicle.info.processing.registrations.jobs;

import com.google.gson.Gson;
import java.io.IOException;
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
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.dto.registration.RegistrationDataPackage;
import ua.vehicle.info.dto.registration.ResourceDataPackage;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

@Slf4j
@RequiredArgsConstructor
public class ParseUrlsFromJsonTask implements Task<Path, List<String>> {

    private final Gson gson;
    private final FileUtilsService fileUtilsService;

    @LogInputOutput
    @Override
    public List<String> process(Path input) {
        var jsonText = getTextFromFile(input);
        var pojo = gson.fromJson(jsonText, RegistrationDataPackage.class);
        return Objects.isNull(pojo) ? Collections.emptyList() :
                pojo.getResources().stream()
                        .map(ResourceDataPackage::getPath)
                        .collect(Collectors.toList());
    }

    @LogInputOutput
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
