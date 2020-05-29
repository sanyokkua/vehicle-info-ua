package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.FuelTypeDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Fuel type jdbc repository.
 */
@Repository
public interface FuelTypeJdbcRepository extends CrudRepository<FuelTypeDto, String>,
        InsertFunctionalityRepository<FuelTypeDto> {

    @Cacheable(cacheNames = "fuel", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
