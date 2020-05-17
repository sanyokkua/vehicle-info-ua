package ua.vehicle.info.dto.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.operation")
public class OperationDto {

    @Id
    @Column("code")
    private Long opCode;
    @Column("description")
    private String description;
}
