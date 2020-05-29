package ua.vehicle.info.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.controllers.users.UserManagementApi;
import ua.vehicle.info.api.dto.users.AppUser;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.mappers.AppUserToUserModelMapper;
import ua.vehicle.info.model.UserModel;
import ua.vehicle.info.services.UserService;

/**
 * The type User rest controller.
 */
@RestController
@RequiredArgsConstructor
public class UserRestController implements UserManagementApi {

    private final UserService userService;
    private final AppUserToUserModelMapper modelMapper;

    @LogInputOutput
    @LogExceptions
    @GetMapping(GET_USER)
    @Override
    public AppUser getUser(@PathVariable int id) {
        var one = userService.findOne(id);
        return modelMapper.mapToAppUser(one);
    }

    @LogInputOutput
    @LogExceptions
    @GetMapping(GET_USER_BY_EMAIL)
    @Override
    public AppUser getUserByEmail(@RequestParam String email) {
        var one = userService.findOne(email);
        return modelMapper.mapToAppUser(one);
    }

    @LogExceptions
    @PostMapping(CREATE_USER)
    @Override
    public AppUser createUser(@RequestBody AppUser appUser) {
        var userModel = modelMapper.mapToUserModel(appUser);
        var created = userService.create(userModel);
        return modelMapper.mapToAppUser(created);
    }

    @LogExceptions
    @PutMapping(UPDATE_USER)
    @Override
    public AppUser updateUser(@RequestBody AppUser appUser, @PathVariable int id) {
        UserModel userModel = modelMapper.mapToUserModel(appUser);
        var updated = userService.update(userModel);
        return modelMapper.mapToAppUser(updated);
    }

    @LogInputOutput
    @LogExceptions
    @DeleteMapping(DELETE_USER)
    @Override
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @LogInputOutput
    @LogExceptions
    @GetMapping(USERS_LIST)
    @Override
    public ResponseEntity<Page<AppUser>> getUsersList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        var all = userService.findAll(PageRequest.of(page, size));
        var mappedResult = all.map(modelMapper::mapToAppUser);
        return ResponseEntity.ok(mappedResult);
    }

}
