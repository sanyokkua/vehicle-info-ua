package ua.vehicle.info.external;

import org.springframework.cloud.openfeign.FeignClient;
import ua.vehicle.info.api.controllers.UserManagementApi;
import ua.vehicle.info.discovery.ServicesNamesConstants;

@FeignClient(ServicesNamesConstants.REST_USER_SERVICE)
public interface UserService extends UserManagementApi {

}
