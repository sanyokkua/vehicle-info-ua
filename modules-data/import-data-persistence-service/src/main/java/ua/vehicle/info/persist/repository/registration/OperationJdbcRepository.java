package ua.vehicle.info.persist.repository.registration;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.registration.OperationDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Operation jdbc repository.
 */
@Repository
public interface OperationJdbcRepository extends CrudRepository<OperationDto, Long>,
        InsertFunctionalityRepository<OperationDto> {

    @Cacheable(cacheNames = "operation", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);
}
