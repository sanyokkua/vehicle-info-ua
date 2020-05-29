package ua.vehicle.info.api.controllers.users;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ua.vehicle.info.api.dto.users.AppUser;

/**
 * The interface User management api.
 * This interface represents all functionality
 * related to work with users
 */
public interface UserManagementApi {

    /**
     * Represents user ID mapping request path
     */
    String USER_ID_MAPPING = "/user/{id}";
    /**
     * Represents get user request path
     */
    String GET_USER = USER_ID_MAPPING;
    /**
     * Represents get user by email request path
     */
    String GET_USER_BY_EMAIL = "/user";
    /**
     * Represents create user request path
     */
    String CREATE_USER = "/user";
    /**
     * Represents update user request path
     */
    String UPDATE_USER = USER_ID_MAPPING;
    /**
     * Represents delete user request path
     */
    String DELETE_USER = USER_ID_MAPPING;
    /**
     * Represents get users list request path
     */
    String USERS_LIST = "/users";

    /**
     * Gets user.
     *
     * @param id the id
     *
     * @return the user
     */
    @GetMapping(GET_USER)
    AppUser getUser(@PathVariable int id);

    /**
     * Gets user by email.
     *
     * @param email the email
     *
     * @return the user by email
     */
    @GetMapping(GET_USER_BY_EMAIL)
    AppUser getUserByEmail(@RequestParam String email);

    /**
     * Create user.
     *
     * @param appUser the app user
     *
     * @return the app user
     */
    @PostMapping(CREATE_USER)
    AppUser createUser(@RequestBody AppUser appUser);

    /**
     * Update user.
     *
     * @param appUser the app user
     * @param id the id
     *
     * @return the app user
     */
    @PutMapping(UPDATE_USER)
    AppUser updateUser(@RequestBody AppUser appUser, @PathVariable int id);

    /**
     * Delete user.
     *
     * @param id the id
     *
     * @return the response entity
     */
    @DeleteMapping(DELETE_USER)
    ResponseEntity<String> deleteUser(@PathVariable int id);

    /**
     * Gets users list.
     *
     * @param page the page
     * @param size the size
     *
     * @return the users list
     */
    @GetMapping(USERS_LIST)
    ResponseEntity<Page<AppUser>> getUsersList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size);
}
