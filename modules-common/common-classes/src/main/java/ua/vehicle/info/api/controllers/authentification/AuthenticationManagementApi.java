package ua.vehicle.info.api.controllers.authentification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.authentication.AuthTokenDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;

/**
 * The interface Authentication management api.
 * It is used in authentication service as its API.
 */
public interface AuthenticationManagementApi {

    /**
     * Represents authenticate request path
     */
    String AUTHENTICATE = "/authenticate";
    /**
     * Represents check uth status request path
     */
    String CHECK = "/check";
    /**
     * Represents get role request path
     */
    String GET_ROLE = "/getRole";

    /**
     * Authenticate user and create auth token
     *
     * @param authUserCredentialsDto the auth user credentials dto
     *
     * @return the auth token dto
     */
    @PostMapping(AUTHENTICATE)
    AuthTokenDto authenticateUser(@RequestBody AuthUserCredentialsDto authUserCredentialsDto);

    /**
     * Check authentication in app.
     *
     * @param tokenDto the token dto
     *
     * @return the boolean value. If user authenticated the true will be returned.
     */
    @PostMapping(CHECK)
    boolean checkAuthentication(@RequestBody AuthTokenDto tokenDto);

    /**
     * Gets role for authentication.
     *
     * @param tokenDto the token dto
     *
     * @return the role for authentication
     */
    @PostMapping(GET_ROLE)
    AppRole getRoleForAuthentication(@RequestBody AuthTokenDto tokenDto);

}
