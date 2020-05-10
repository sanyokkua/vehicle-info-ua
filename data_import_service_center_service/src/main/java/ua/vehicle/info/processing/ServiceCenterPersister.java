package ua.vehicle.info.processing;

import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.dto.ServiceCenter;
import ua.vehicle.info.processing.persistance.Persister;

@Slf4j
public class ServiceCenterPersister implements Persister<ServiceCenter> {

    @LogTimeMeasures
    @LogExceptions
    @Override
    public void persist(ServiceCenter input) {
        //TODO: implement persisting
        log.info("Service Center: {}", input);
    }
}
