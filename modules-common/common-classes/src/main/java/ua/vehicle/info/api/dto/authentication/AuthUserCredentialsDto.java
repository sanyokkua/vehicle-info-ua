package ua.vehicle.info.api.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Auth user credentials dto.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCredentialsDto {

    private String username;
    private String password;
}
