package ua.vehicle.info.external;

import org.springframework.cloud.openfeign.FeignClient;
import ua.vehicle.info.api.controllers.users.UserManagementApi;
import ua.vehicle.info.discovery.ServicesNamesConstants;

/**
 * The interface User service.
 */
@FeignClient(ServicesNamesConstants.REST_USER_SERVICE)
public interface UserService extends UserManagementApi {

}
