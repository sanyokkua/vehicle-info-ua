package ua.vehicle.info.processing.registrations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.processor.tasks.AbstractDownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.AbstractPersistCsvRecordTask;
import ua.vehicle.info.processing.processor.tasks.ReadCsvFileTask;
import ua.vehicle.info.processing.processor.tasks.UnzipTask;
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
    private final ReadCsvFileTask step5ReadCsvFile;
    @Qualifier("persistRegistrationRecordTask")
    private final AbstractPersistCsvRecordTask<RegistrationRecord> step6PersistRecordsFromCsv;

    public void processing(String url) {
        var jsonPath = step1DownloadJsonWithUrls.process(url);
        var urlsMap = step2ParseUrlsInJson.process(jsonPath);
        urlsMap.forEach((archiveUrl) -> {
            var archivePath = step3DownloadArchiveForUrl.process(archiveUrl);
            var csvFile = step4UnArchiveZip.process(archivePath);
            var csvRecords = step5ReadCsvFile.process(csvFile);
            step6PersistRecordsFromCsv.process(csvRecords);
        });

    }
}
