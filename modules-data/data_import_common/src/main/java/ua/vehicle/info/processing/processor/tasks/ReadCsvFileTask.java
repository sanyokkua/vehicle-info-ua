package ua.vehicle.info.processing.processor.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Iterator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

@Slf4j
@RequiredArgsConstructor
public class ReadCsvFileTask implements Task<Path, Iterator<CSVRecord>> {

    protected final FileUtilsService fileUtilsService;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public Iterator<CSVRecord> process(@NonNull Path input) {
        var encoding = fileUtilsService.getEncoding(input);
        var delimiter = getDelimiter(input, encoding);
        try {
            return CSVParser.parse(input, Charset.forName(encoding), CSVFormat.DEFAULT
                    .withDelimiter(delimiter)
                    .withFirstRecordAsHeader())
                    .iterator();
        } catch (IOException e) {
            return Collections.emptyIterator();
        }
    }

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    private char getDelimiter(@NonNull Path textFile, @NonNull String encoding) {
        try (var fileStream = Files.lines(textFile)) {
            var headerString = fileStream.findFirst().orElse(",");
            var headerStringProcessed = headerString.replaceAll("\"", "");
            var headers = headerStringProcessed.split("\\W");
            if (headers.length > 0) {
                var firstColumn = headers[0];
                var chars = headerStringProcessed
                        .replace(firstColumn, "")
                        .substring(0, 1)
                        .toCharArray();
                return chars[0];
            }
        } catch (IOException e) {
            log.error("Problem with recognizing delimiter", e);
        }
        return ',';
    }

}
