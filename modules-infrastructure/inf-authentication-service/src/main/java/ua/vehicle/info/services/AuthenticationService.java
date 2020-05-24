package ua.vehicle.info.services;

import ua.vehicle.info.dto.AppRole;
import ua.vehicle.info.dto.AuthTokeDto;
import ua.vehicle.info.dto.AuthUserCredentialsDto;

public interface AuthenticationService {

    AuthTokeDto authenticate(AuthUserCredentialsDto authUserCredentialsDto);

    boolean checkIsValid(AuthTokeDto tokeDto);

    AppRole getRoleForAuthentication(AuthTokeDto tokeDto);
}
