package ua.vehicle.info.services;

import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;

public interface AuthenticationService {

    AuthTokeDto authenticate(AuthUserCredentialsDto authUserCredentialsDto);

    boolean checkIsValid(AuthTokeDto tokeDto);

    AppRole getRoleForAuthentication(AuthTokeDto tokeDto);
}
