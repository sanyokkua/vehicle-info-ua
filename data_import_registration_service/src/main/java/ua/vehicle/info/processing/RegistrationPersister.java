package ua.vehicle.info.processing;

import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.persistance.Persister;

@Slf4j
public class RegistrationPersister implements Persister<RegistrationRecord> {

    @LogExceptions
    @Override
    public void persist(RegistrationRecord input) {
        // TODO: implement logic for persistence
    }
}
