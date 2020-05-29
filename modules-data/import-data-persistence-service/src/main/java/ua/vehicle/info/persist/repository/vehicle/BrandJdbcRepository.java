package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.BrandDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

/**
 * The interface Brand jdbc repository.
 */
@Repository
public interface BrandJdbcRepository extends CrudRepository<BrandDto, String>,
        InsertFunctionalityRepository<BrandDto> {

    @Cacheable(cacheNames = "brand", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
