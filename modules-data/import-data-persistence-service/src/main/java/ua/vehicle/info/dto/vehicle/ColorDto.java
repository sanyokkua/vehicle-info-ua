package ua.vehicle.info.dto.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.color")
public class ColorDto {

    @Id
    @Column("color_name")
    private String colorName;
}
