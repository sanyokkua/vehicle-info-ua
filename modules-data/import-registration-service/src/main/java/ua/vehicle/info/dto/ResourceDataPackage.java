package ua.vehicle.info.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Resource data package.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDataPackage {

    private String mimetype;
    private String profile;
    private String name;
    private String format;
    private String encoding;
    private String path;
}
