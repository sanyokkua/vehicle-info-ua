package ua.vehicle.info.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.dto.AppUser;

@FeignClient("rest-user-service")
public interface UserService {

    @LogInputOutput
    @LogExceptions
    @GetMapping("/user/{id}")
    AppUser getUser(@PathVariable int id);

    @LogInputOutput
    @LogExceptions
    @GetMapping("/user")
    AppUser getUserByEmail(@RequestParam String email);

    @LogExceptions
    @PostMapping("/user")
    AppUser createUser(@RequestBody AppUser appUser);

    @LogExceptions
    @PutMapping("/user/{id}")
    AppUser updateUser(@RequestBody AppUser appUser, @PathVariable int id);

    @LogInputOutput
    @LogExceptions
    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable int id);

}
