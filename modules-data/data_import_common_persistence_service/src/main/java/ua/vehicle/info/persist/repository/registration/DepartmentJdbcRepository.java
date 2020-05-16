package ua.vehicle.info.persist.repository.registration;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.registration.DepartmentDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

@Repository
public interface DepartmentJdbcRepository extends CrudRepository<DepartmentDto, Long>,
        InsertFunctionalityRepository<DepartmentDto> {

    @Cacheable(cacheNames = "department", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);
}
