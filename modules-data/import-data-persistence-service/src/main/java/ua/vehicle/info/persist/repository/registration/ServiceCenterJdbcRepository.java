package ua.vehicle.info.persist.repository.registration;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.registration.ServiceCenterDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Service center jdbc repository.
 */
@Repository
public interface ServiceCenterJdbcRepository extends CrudRepository<ServiceCenterDto, Long>,
        InsertFunctionalityRepository<ServiceCenterDto> {

    @Cacheable(cacheNames = "serviceCenter", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);
}
