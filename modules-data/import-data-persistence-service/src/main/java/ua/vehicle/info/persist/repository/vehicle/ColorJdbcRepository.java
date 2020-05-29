package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.ColorDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Color jdbc repository.
 */
@Repository
public interface ColorJdbcRepository extends CrudRepository<ColorDto, String>,
        InsertFunctionalityRepository<ColorDto> {

    @Cacheable(cacheNames = "color", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
