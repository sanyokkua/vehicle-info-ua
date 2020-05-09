package ua.vehicle.info.processing.registrations;

import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.LogOnlyException;
import ua.vehicle.info.dto.registration.RegistrationRecord;
import ua.vehicle.info.processing.persistance.Persister;

@Slf4j
public class RegistrationPersister implements Persister<RegistrationRecord> {

    @LogOnlyException
    @Override
    public void persist(RegistrationRecord input) {
        // TODO: implement logic for persistence
    }
}
