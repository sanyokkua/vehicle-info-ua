package ua.vehicle.info.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ua.vehicle.info.dto.AppUser;

public interface UserManagementApi {

    String USER_ID_MAPPING = "/user/{id}";
    String GET_USER = USER_ID_MAPPING;
    String GET_USER_BY_EMAIL = "/user";
    String CREATE_USER = "/user";
    String UPDATE_USER = USER_ID_MAPPING;
    String DELETE_USER = USER_ID_MAPPING;
    String USERS_LIST = "/users";

    @GetMapping(GET_USER)
    AppUser getUser(@PathVariable int id);

    @GetMapping(GET_USER_BY_EMAIL)
    AppUser getUserByEmail(@RequestParam String email);

    @PostMapping(CREATE_USER)
    AppUser createUser(@RequestBody AppUser appUser);

    @PutMapping(UPDATE_USER)
    AppUser updateUser(@RequestBody AppUser appUser, @PathVariable int id);

    @DeleteMapping(DELETE_USER)
    ResponseEntity<String> deleteUser(@PathVariable int id);

    @GetMapping(USERS_LIST)
    ResponseEntity<Page<AppUser>> getUsersList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size);
}
