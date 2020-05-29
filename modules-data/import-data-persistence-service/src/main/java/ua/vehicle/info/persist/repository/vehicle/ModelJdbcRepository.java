package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.ModelDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Model jdbc repository.
 */
@Repository
public interface ModelJdbcRepository extends CrudRepository<ModelDto, String>,
        InsertFunctionalityRepository<ModelDto> {

    @Cacheable(cacheNames = "model", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
