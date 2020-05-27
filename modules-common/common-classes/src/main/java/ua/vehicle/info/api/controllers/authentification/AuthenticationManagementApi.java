package ua.vehicle.info.api.controllers.authentification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;

public interface AuthenticationManagementApi {

    String AUTHENTICATE = "/authenticate";
    String CHECK = "/check";
    String GET_ROLE = "/getRole";

    @PostMapping(AUTHENTICATE)
    AuthTokeDto authenticateUser(@RequestBody AuthUserCredentialsDto authUserCredentialsDto);

    @PostMapping(CHECK)
    boolean checkAuthentication(@RequestBody AuthTokeDto tokeDto);

    @PostMapping(GET_ROLE)
    AppRole getRoleForAuthentication(@RequestBody AuthTokeDto tokeDto);

}
