package ua.vehicle.info.services;

import ua.vehicle.info.api.dto.authentication.AuthTokenDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;

/**
 * The interface Authentication service.
 */
public interface AuthenticationService {

    /**
     * Authenticate auth toke dto.
     *
     * @param authUserCredentialsDto the auth user credentials dto
     *
     * @return the auth toke dto
     */
    AuthTokenDto authenticate(AuthUserCredentialsDto authUserCredentialsDto);

    /**
     * Check is valid boolean.
     *
     * @param tokeDto the toke dto
     *
     * @return the boolean
     */
    boolean checkIsValid(AuthTokenDto tokeDto);

    /**
     * Gets role for authentication.
     *
     * @param tokeDto the toke dto
     *
     * @return the role for authentication
     */
    AppRole getRoleForAuthentication(AuthTokenDto tokeDto);
}
