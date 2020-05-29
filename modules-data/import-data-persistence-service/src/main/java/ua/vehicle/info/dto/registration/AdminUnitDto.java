package ua.vehicle.info.dto.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * The type Admin unit dto.
 */
@Data
@NoArgsConstructor
@Table("ua_vehicle_info.admin_unit")
public class AdminUnitDto {


    @Id
    @Column("unit_number")
    private String unitNumber;
    @Transient
    private String level1Code;
    @Transient
    private String level2Code;
    @Transient
    private String level3Code;
    @Transient
    private String level4Code;
    @Column("category")
    private String category;
    @Column("unit_name")
    private String name;
}
