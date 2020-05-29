package ua.vehicle.info.dto.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * The type Department dto.
 */
@Data
@NoArgsConstructor
@Table("ua_vehicle_info.department")
public class DepartmentDto {

    @Id
    @Column("code")
    private Long depCode;
    @Column("department_name")
    private String depName;
}
