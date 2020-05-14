package ua.vehicle.info.dto.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.purpose")
public class PurposeDto {

    @Id
    @Column("purpose")
    private String purpose;
}
