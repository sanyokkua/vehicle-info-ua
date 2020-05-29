package ua.vehicle.info.persist;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.dto.registration.ServiceCenterDto;
import ua.vehicle.info.persist.repository.registration.ServiceCenterJdbcRepository;

/**
 * The type Service center service.
 */
@Service
@RequiredArgsConstructor
public class ServiceCenterService {

    private final ServiceCenterJdbcRepository repository;

    /**
     * Save.
     *
     * @param obj the obj
     */
    @SuppressRuntimeExceptions
    @LogExceptions
    public void save(ServiceCenterDto obj) {
        if (Objects.isNull(obj)) {
            return;
        }
        var exists = repository.existsById(obj.getCenterNumber());
        if (!exists) {
            repository.customInsert(obj);
        }
    }

}
