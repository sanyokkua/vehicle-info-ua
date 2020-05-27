package ua.vehicle.info.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.authentication.AuthUserCredentialsDto;
import ua.vehicle.info.api.dto.users.AppRole;
import ua.vehicle.info.services.AuthenticationService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public AuthTokeDto authenticateUser(@RequestBody AuthUserCredentialsDto authUserCredentialsDto) {
        return authenticationService.authenticate(authUserCredentialsDto);
    }

    @PostMapping("/check")
    public boolean checkAuthentication(@RequestBody AuthTokeDto tokeDto) {
        return authenticationService.checkIsValid(tokeDto);
    }

    @PostMapping("/getRole")
    public AppRole getRoleForAuthentication(@RequestBody AuthTokeDto tokeDto) {
        return authenticationService.getRoleForAuthentication(tokeDto);
    }
}
