package ua.vehicle.info.processing;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.jobs.GetCsvPathTask;
import ua.vehicle.info.processing.jobs.ParseUrlsFromJsonTask;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.DownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;

@Component
@RequiredArgsConstructor
public class RegistrationProcessing extends Processor {

    private final DownloadFileTask step1DownloadJsonWithUrls;
    private final ParseUrlsFromJsonTask step2ParseUrlsInJson;
    private final DownloadFileTask step3DownloadArchiveForUrl;
    private final UnzipTask step4UnArchiveZip;
    private final ReadCsvFileTask step6ReadCsvFile;
    @Qualifier("persistRegistrationRecordTask")
    private final PersistRecordTask<CSVRecord, RegistrationRecord> step7PersistRecordsFromCsv;
    private final GetCsvPathTask step5getCsvPathTask;
    private final DeleteFilesTask stepLastDeleteFilesTask;

    @LogTimeMeasures
    @LogInputOutput
    @LogExceptions
    @Override
    public void runSteps(URL url) {
        var jsonPath = step1DownloadJsonWithUrls.process(url);
        var urlsMap = step2ParseUrlsInJson.process(jsonPath);
        urlsMap.forEach(archiveUrl -> {
            var archivePath = step3DownloadArchiveForUrl.process(archiveUrl);
            var csvFileFolder = step4UnArchiveZip.process(archivePath);
            var csvFile = step5getCsvPathTask.process(csvFileFolder);
            var csvRecords = step6ReadCsvFile.process(csvFile);
            step7PersistRecordsFromCsv.process(csvRecords);
            var paths = Arrays.asList(csvFile, csvFileFolder, archivePath);
            stepLastDeleteFilesTask.process(paths);
        });
        stepLastDeleteFilesTask.process(Collections.singletonList(jsonPath));
    }
}
