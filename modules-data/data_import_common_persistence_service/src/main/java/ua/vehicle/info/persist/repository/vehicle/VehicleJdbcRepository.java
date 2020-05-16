package ua.vehicle.info.persist.repository.vehicle;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.dto.vehicle.VehicleDto;
import ua.vehicle.info.persist.repository.InsertFunctionalityRepository;

@Repository
public interface VehicleJdbcRepository extends CrudRepository<VehicleDto, Long>,
        InsertFunctionalityRepository<VehicleDto> {

    @Cacheable(cacheNames = "vehicle", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);

    @Query("select * from ua_vehicle_info.vehicle v where "
            + "v.model like :model and "
            + "v.body like :body and "
            + "v.kind like :kind and "
            + "v.fuel like :fuel and "
            + "v.color like :color and "
            + "v.engine_capacity = :engine_capacity and "
            + "v.make_year = :make_year and "
            + "v.own_weight = :own_weight and "
            + "v.total_weight = :total_weight "
    )
    VehicleDto findByFields(@Param("brand") String brand,
            @Param("model") String model,
            @Param("body") String body,
            @Param("kind") String kind,
            @Param("fuel") String fuel,
            @Param("color") String color,
            @Param("engine_capacity") Integer engineCapacity,
            @Param("make_year") Integer makeYear,
            @Param("own_weight") Integer ownWeight,
            @Param("total_weight") Integer totalWeight
    );

    @Cacheable(cacheNames = "findVehicle", unless = "#result == null", key = "#dto.hashCode()")
    default VehicleDto findVehicle(VehicleDto dto) {
        return findByFields(dto.getBrand(),
                dto.getModel(),
                dto.getBody(),
                dto.getKind(),
                dto.getFuel(),
                dto.getColor(),
                dto.getEngineCapacity(),
                dto.getMakeYear(),
                dto.getOwnWeight(),
                dto.getTotalWeight());
    }
}
