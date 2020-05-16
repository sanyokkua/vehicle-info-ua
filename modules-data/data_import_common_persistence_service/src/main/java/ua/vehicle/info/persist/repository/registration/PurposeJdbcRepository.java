package ua.vehicle.info.persist.repository.registration;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.registration.PurposeDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

@Repository
public interface PurposeJdbcRepository extends CrudRepository<PurposeDto, String>,
        InsertFunctionalityRepository<PurposeDto> {

    @Cacheable(cacheNames = "purpose", unless = "#result == false ", key = "#s.hashCode()")
    @Override
    boolean existsById(String s);
}
