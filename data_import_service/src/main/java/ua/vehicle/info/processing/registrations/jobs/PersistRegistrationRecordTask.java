package ua.vehicle.info.processing.registrations.jobs;

import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.processor.tasks.AbstractPersistCsvRecordTask;

public class PersistRegistrationRecordTask extends AbstractPersistCsvRecordTask<RegistrationRecord> {

    @Override
    public RegistrationRecord map(CSVRecord input) {
        return null;
    }

    @Override
    public boolean persist(RegistrationRecord record) {
        return false;
    }
}
