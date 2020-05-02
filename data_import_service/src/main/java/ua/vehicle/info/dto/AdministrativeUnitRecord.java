package ua.vehicle.info.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdministrativeUnitRecord {

    private Long code;
    private String type;
    private String name;
}

