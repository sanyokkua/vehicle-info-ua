package ua.vehicle.info.persist.chain.adminunit;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.dto.registration.AdminUnitDto;
import ua.vehicle.info.persist.chain.Handler;
import ua.vehicle.info.persist.repository.registration.AdminUnitJdbcRepository;

@Slf4j
@RequiredArgsConstructor
public abstract class AdminUnitHandler implements Handler<AdminUnitDto> {

    protected final AdminUnitJdbcRepository repository;
    private Handler<AdminUnitDto> next;

    @LogInputOutput
    @LogExceptions
    @LogTimeMeasures
    @Override
    public Handler<AdminUnitDto> setNext(Handler<AdminUnitDto> next) {
        this.next = next;
        return this.next;
    }

    @LogExceptions
    @Override
    public void handle(AdminUnitDto obj) {
        if (!canHandle(obj) && Objects.nonNull(next)) {
            next.handle(obj);
        }
        var unitNumber = getUnitNumber(obj);
        obj.setUnitNumber(unitNumber);
        persist(obj);
    }

    @LogExceptions
    private void persist(AdminUnitDto obj) {
        try {
            if (!repository.existsById(obj.getUnitNumber())) {
                repository.customInsert(obj);
            }
        } catch (Exception ex) {
            log.warn("Problem with persisting {}", obj, ex);
        }
    }

    protected abstract String getUnitNumber(AdminUnitDto obj);

    protected abstract boolean canHandle(AdminUnitDto obj);
}
