package ua.vehicle.info.api.controllers.management;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The interface Services status api.
 * It is used in app-management service
 * to check status os services.
 */
public interface ServicesStatusApi {

    /**
     * Represents service list request path
     */
    String SERVICES_LIST = "/services";
    /**
     * Represents service list with running apps request path
     */
    String RUNNING_SERVICES_LIST = "/services/running";

    /**
     * Gets all services that exists in app
     *
     * @return the all services names
     */
    @GetMapping(SERVICES_LIST)
    List<String> getAllServices();

    /**
     * Gets all running services at the moment in app.
     *
     * @return the all running services names
     */
    @GetMapping(RUNNING_SERVICES_LIST)
    List<String> getAllRunningServices();

}
