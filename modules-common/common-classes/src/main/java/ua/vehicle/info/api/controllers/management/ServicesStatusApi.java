package ua.vehicle.info.api.controllers.management;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface ServicesStatusApi {

    String SERVICES_LIST = "/services";
    String RUNNING_SERVICES_LIST = "/services/running";

    @GetMapping(SERVICES_LIST)
    List<String> getAllServices();

    @GetMapping(RUNNING_SERVICES_LIST)
    List<String> getAllRunningServices();

}
