package ua.vehicle.info.processing.registrations.jobs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.aspects.LogOnlyException;
import ua.vehicle.info.dto.registration.RegistrationRecord;
import ua.vehicle.info.processing.processor.tasks.AbstractPersistCsvRecordTask;
import ua.vehicle.info.processing.registrations.CsvRecordToRegistrationMapper;
import ua.vehicle.info.processing.registrations.RegistrationPersister;

@RequiredArgsConstructor
@Slf4j
public class PersistRegistrationRecordTask extends AbstractPersistCsvRecordTask<RegistrationRecord> {

    private final CsvRecordToRegistrationMapper mapper;
    private final RegistrationPersister persister;

    @LogOnlyException
    @Override
    public RegistrationRecord map(CSVRecord input) {
        return mapper.map(input);
    }

    @LogOnlyException
    @Override
    public void persist(RegistrationRecord record) {
        persister.persist(record);
    }
}
