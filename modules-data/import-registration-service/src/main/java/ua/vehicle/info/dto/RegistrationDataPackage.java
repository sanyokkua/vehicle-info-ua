package ua.vehicle.info.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Registration data package.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDataPackage {

    private List<ResourceDataPackage> resources;
}
