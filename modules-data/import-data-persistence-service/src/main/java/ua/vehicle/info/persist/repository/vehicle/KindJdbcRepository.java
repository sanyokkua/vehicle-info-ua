package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.KindDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Kind jdbc repository.
 */
@Repository
public interface KindJdbcRepository extends CrudRepository<KindDto, String>,
        InsertFunctionalityRepository<KindDto> {

    @Cacheable(cacheNames = "kind", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
