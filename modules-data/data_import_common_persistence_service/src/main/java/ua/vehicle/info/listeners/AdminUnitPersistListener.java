package ua.vehicle.info.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.dto.registration.AdminUnitDto;
import ua.vehicle.info.mappers.registration.AdminUnitDtoMapper;
import ua.vehicle.info.persist.chain.Handler;

@Slf4j
@RequiredArgsConstructor
public class AdminUnitPersistListener implements OnMessageListener<AdminUnitRecord> {

    private final AdminUnitDtoMapper mapper;
    private final Handler<AdminUnitDto> handler;

    @LogExceptions
    @SuppressRuntimeExceptions
    @Override
    public void onMessage(AdminUnitRecord message) {
        var dto = mapper.map(message);
        handler.handle(dto);
    }
}
