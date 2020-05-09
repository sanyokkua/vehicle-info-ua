package ua.vehicle.info.processing.registrations;

import java.util.Arrays;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.vehicle.info.dto.registration.RegistrationRecord;
import ua.vehicle.info.processing.processor.tasks.AbstractDownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.AbstractPersistCsvRecordTask;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;
import ua.vehicle.info.processing.registrations.jobs.GetCsvPathTask;
import ua.vehicle.info.processing.registrations.jobs.ParseUrlsFromJsonTask;

@Component
@RequiredArgsConstructor
public class RegistrationProcessing {

    @Qualifier("downloadJsonTask")
    private final AbstractDownloadFileTask step1DownloadJsonWithUrls;
    private final ParseUrlsFromJsonTask step2ParseUrlsInJson;
    @Qualifier("downloadZipArchiveTask")
    private final AbstractDownloadFileTask step3DownloadArchiveForUrl;
    private final UnzipTask step4UnArchiveZip;
    private final ReadCsvFileTask step6ReadCsvFile;
    @Qualifier("persistRegistrationRecordTask")
    private final AbstractPersistCsvRecordTask<RegistrationRecord> step7PersistRecordsFromCsv;
    private final GetCsvPathTask step5getCsvPathTask;
    private final DeleteFilesTask stepLastDeleteFilesTask;

    public void processing(String url) {
        var jsonPath = step1DownloadJsonWithUrls.process(url);
        var urlsMap = step2ParseUrlsInJson.process(jsonPath);
        urlsMap.forEach((archiveUrl) -> {
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
