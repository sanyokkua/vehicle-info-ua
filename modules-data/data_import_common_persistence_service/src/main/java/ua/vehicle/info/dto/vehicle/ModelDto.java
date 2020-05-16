package ua.vehicle.info.dto.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.model")
public class ModelDto {

    @Id
    @Column("model_name")
    private String modelName;
}
