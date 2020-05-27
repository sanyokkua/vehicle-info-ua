package ua.vehicle.info.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.controllers.registrations.manage.SearchManagementApi;
import ua.vehicle.info.api.dto.Response;
import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.search.SearchQueryDto;

@RestController
public class VehicleSearchRestController implements SearchManagementApi {

    @PostMapping(SAVE_QUERY)
    @Override
    public Response saveQuery(SearchQueryDto queryDto, @RequestBody AuthTokeDto authTokeDto) {
        return null;
    }

    @GetMapping(QUERY_ID)
    @Override
    public SearchQueryDto loadQuery(String id, @RequestBody AuthTokeDto authTokeDto) {
        return null;
    }

    @GetMapping(GET_ALL_QUERIES)
    @Override
    public Response getAllQueries(@RequestBody AuthTokeDto authTokeDto) {
        return null;
    }

    @DeleteMapping(QUERY_ID)
    @Override
    public Response deleteQuery(String id, @RequestBody AuthTokeDto authTokeDto) {
        return null;
    }
}
