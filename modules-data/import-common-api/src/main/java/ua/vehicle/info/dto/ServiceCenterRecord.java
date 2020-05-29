package ua.vehicle.info.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Service center record.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCenterRecord {

    private Long centerNumber;
    private String address;
    private String email;
}
