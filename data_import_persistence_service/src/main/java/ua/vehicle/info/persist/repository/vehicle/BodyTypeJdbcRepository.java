package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.BodyTypeDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

@Repository
public interface BodyTypeJdbcRepository extends CrudRepository<BodyTypeDto, String>,
        InsertFunctionalityRepository<BodyTypeDto> {

    @Cacheable(cacheNames = "body", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
