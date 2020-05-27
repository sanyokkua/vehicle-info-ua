package ua.vehicle.info.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.controllers.authentification.AuthenticationManagementApi;
import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;
import ua.vehicle.info.services.AuthenticationService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthRestController implements AuthenticationManagementApi {

    private final AuthenticationService authenticationService;

    @PostMapping(AUTHENTICATE)
    @Override
    public AuthTokeDto authenticateUser(@RequestBody AuthUserCredentialsDto authUserCredentialsDto) {
        return authenticationService.authenticate(authUserCredentialsDto);
    }

    @PostMapping(CHECK)
    @Override
    public boolean checkAuthentication(@RequestBody AuthTokeDto tokeDto) {
        return authenticationService.checkIsValid(tokeDto);
    }

    @PostMapping(GET_ROLE)
    @Override
    public AppRole getRoleForAuthentication(@RequestBody AuthTokeDto tokeDto) {
        return authenticationService.getRoleForAuthentication(tokeDto);
    }
}
