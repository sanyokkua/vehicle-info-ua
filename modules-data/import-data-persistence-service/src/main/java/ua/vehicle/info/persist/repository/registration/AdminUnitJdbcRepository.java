package ua.vehicle.info.persist.repository.registration;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.registration.AdminUnitDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Admin unit jdbc repository.
 */
@Repository
public interface AdminUnitJdbcRepository extends CrudRepository<AdminUnitDto, String>,
        InsertFunctionalityRepository<AdminUnitDto> {

    @Cacheable(cacheNames = "adminUnit", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
