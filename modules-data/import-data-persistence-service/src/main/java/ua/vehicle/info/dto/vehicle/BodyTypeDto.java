package ua.vehicle.info.dto.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * The type Body type dto.
 */
@Data
@NoArgsConstructor
@Table("ua_vehicle_info.body_type")
public class BodyTypeDto {

    @Id
    @Column("body_name")
    private String bodyName;
}
