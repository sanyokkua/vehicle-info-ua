package ua.vehicle.info.processing.processor.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Collections;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import ua.vehicle.info.aspects.LogInputOutput;
import ua.vehicle.info.processing.processor.Task;
import ua.vehicle.info.services.FileUtilsService;

@Slf4j
@RequiredArgsConstructor
public class ReadCsvFileTask implements Task<Path, Iterable<CSVRecord>> {

    protected final FileUtilsService fileUtilsService;

    @LogInputOutput
    @Override
    public Iterable<CSVRecord> process(@NonNull Path input) {
        var encoding = fileUtilsService.getEncoding(input);
        var delimiter = getDelimiter(input.toFile(), encoding);

        return () -> {
            try {
                return CSVParser.parse(input, Charset.forName(encoding), CSVFormat.DEFAULT
                        .withDelimiter(delimiter)
                        .withFirstRecordAsHeader())
                        .iterator();
            } catch (IOException ex) {
                log.warn("readCsvFile: IOException happened", ex);
            }
            return Collections.emptyIterator();
        };
    }

    @LogInputOutput
    private char getDelimiter(@NonNull File textFile, @NonNull String encoding) {
        try {
            var strings = FileUtils.readLines(textFile, encoding);
            var headerString = strings.get(0);
            var headerStringProcessed = headerString.replaceAll("\"", "");
            var headers = headerStringProcessed.split("\\W");
            if (headers.length > 0) {
                var firstColumn = headers[0];
                var chars = headerString
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
