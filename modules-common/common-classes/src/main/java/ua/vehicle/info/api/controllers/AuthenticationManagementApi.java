package ua.vehicle.info.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;

public interface AuthenticationManagementApi {

    @PostMapping("/authenticate")
    AuthTokeDto authenticateUser(@RequestBody AuthUserCredentialsDto authUserCredentialsDto);

    @PostMapping("/check")
    boolean checkAuthentication(@RequestBody AuthTokeDto tokeDto);

    @PostMapping("/getRole")
    AppRole getRoleForAuthentication(@RequestBody AuthTokeDto tokeDto);

}
