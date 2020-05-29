package ua.vehicle.info.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.mappers.registration.ServiceCenterDtoMapper;
import ua.vehicle.info.persist.ServiceCenterService;

/**
 * The type Service center persist listener.
 */
@Slf4j
@RequiredArgsConstructor
public class ServiceCenterPersistListener implements OnMessageListener<ServiceCenterRecord> {

    private final ServiceCenterDtoMapper mapper;
    private final ServiceCenterService service;

    @LogExceptions
    @Override
    public void onMessage(ServiceCenterRecord message) {
        var dto = mapper.map(message);
        service.save(dto);
    }
}
