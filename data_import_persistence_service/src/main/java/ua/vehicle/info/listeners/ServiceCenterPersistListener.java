package ua.vehicle.info.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.mappers.registration.ServiceCenterDtoMapper;

@Slf4j
@RequiredArgsConstructor
public class ServiceCenterPersistListener implements OnMessageListener<ServiceCenterRecord> {

    private final ServiceCenterDtoMapper mapper;

    @LogExceptions
    @Override
    public void onMessage(ServiceCenterRecord message) {
        log.info("Message to persist: {}", message);
    }
}
