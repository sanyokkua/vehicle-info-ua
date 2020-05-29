package ua.vehicle.info.api.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Auth token dto.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthTokenDto {

    private String token;
}
