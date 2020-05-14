package ua.vehicle.info.persist.repository.registration;

import java.time.LocalDate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.registration.RegistrationDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

@Repository
public interface RegistrationJdbcRepository extends CrudRepository<RegistrationDto, Long>,
        InsertFunctionalityRepository<RegistrationDto> {

    @Cacheable(cacheNames = "registration", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);

    @Query("select * from ua_vehicle_info.registration r where "
            + "r.purpose like :purpose and "
            + "r.dep_code = :dep_code and "
            + "r.admin_unit like :admin_unit and "
            + "r.oper_code = :oper_code and "
            + "r.vehicle_id = :vehicle_id and "
            + "r.reg_date = :reg_date and "
            + "r.person_type like :person_type and "
            + "r.reg_number like :reg_number "
    )
    RegistrationDto findByFields(@Param("purpose") String purpose,
            @Param("dep_code") Long depCode,
            @Param("admin_unit") String adminUnit,
            @Param("oper_code") Long opCode,
            @Param("vehicle_id") Long vehicleId,
            @Param("reg_date") LocalDate regDate,
            @Param("person_type") String personType,
            @Param("reg_number") String regNumber
    );

    @Cacheable(cacheNames = "findRegistration", unless = "#result == null", key = "#dto.hashCode()")
    default RegistrationDto findRegistration(RegistrationDto dto) {
        return findByFields(dto.getPurpose(),
                dto.getDepCode(),
                dto.getAdminUnit(),
                dto.getOperCode(),
                dto.getVehicleId(),
                dto.getRegDate(),
                dto.getPersonType(),
                dto.getRegNumber());
    }
}
