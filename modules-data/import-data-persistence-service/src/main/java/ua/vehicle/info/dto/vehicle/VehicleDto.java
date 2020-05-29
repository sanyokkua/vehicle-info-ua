package ua.vehicle.info.dto.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * The type Vehicle dto.
 */
@Data
@NoArgsConstructor
@Table("ua_vehicle_info.vehicle")
public class VehicleDto {

    @Id
    @Column("vehicle_id")
    private Long vehicleId;
    @Column("brand")
    private String brand;
    @Column("model")
    private String model;
    @Column("body")
    private String body;
    @Column("kind")
    private String kind;
    @Column("fuel")
    private String fuel;
    @Column("color")
    private String color;
    @Column("engine_capacity")
    private int engineCapacity;
    @Column("make_year")
    private int makeYear;
    @Column("own_weight")
    private int ownWeight;
    @Column("total_weight")
    private int totalWeight;
}
