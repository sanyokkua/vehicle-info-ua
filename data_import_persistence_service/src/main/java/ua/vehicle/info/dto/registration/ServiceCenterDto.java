package ua.vehicle.info.dto.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.service_center")
public class ServiceCenterDto {

    @Id
    @Column("center_number")
    private Long centerNumber;
    @Column("address")
    private String address;
    @Column("email")
    private String email;
}
