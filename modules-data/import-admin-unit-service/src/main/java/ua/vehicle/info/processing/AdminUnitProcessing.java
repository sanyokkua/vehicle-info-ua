package ua.vehicle.info.processing;

import java.net.URL;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.processing.jobs.ParseRecordsTask;
import ua.vehicle.info.processing.processor.tasks.DeleteFilesTask;
import ua.vehicle.info.processing.processor.tasks.DownloadFileTask;
import ua.vehicle.info.processing.processor.tasks.PersistRecordTask;

/**
 * The type Admin unit processing.
 */
@Component
@RequiredArgsConstructor
public class AdminUnitProcessing extends Processor {

    private final DownloadFileTask step1DownloadJson;
    private final ParseRecordsTask step2ParseRecords;
    private final PersistRecordTask<AdminUnitRecord, AdminUnitRecord> step3PersistRecords;
    private final DeleteFilesTask stepLastDeleteFilesTask;

    @Override
    protected void runSteps(URL url) {
        var jsonPath = step1DownloadJson.process(url);
        var records = step2ParseRecords.process(jsonPath);
        step3PersistRecords.process(records);
        stepLastDeleteFilesTask.process(Collections.singletonList(jsonPath));
    }
}
