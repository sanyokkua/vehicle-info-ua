package ua.vehicle.info.dto.registration;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_info.registration")
public class RegistrationDto {

    @Id
    @Column("reg_id")
    private Long regId;
    @Column("purpose")
    private String purpose;
    @Column("dep_code")
    private long depCode;
    @Column("admin_unit")
    private String adminUnit;
    @Column("oper_code")
    private long operCode;
    @Column("vehicle_id")
    private long vehicleId;
    @Column("reg_date")
    private LocalDate regDate;
    @Column("person_type")
    private String personType;
    @Column("reg_number")
    private String regNumber;
}
