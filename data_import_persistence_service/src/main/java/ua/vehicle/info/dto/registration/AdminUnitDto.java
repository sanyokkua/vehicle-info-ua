package ua.vehicle.info.dto.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.admin_unit")
public class AdminUnitDto {

    @Id
    @Column("unit_number")
    private String unitNumber;
    @Column("level1_code")
    private String level1Code;
    @Column("level2_code")
    private String level2Code;
    @Column("level3_code")
    private String level3Code;
    @Column("level4_code")
    private String level4Code;
    @Column("category")
    private String category;
    @Column("unit_name")
    private String name;
}
