package ua.vehicle.info.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.info.api.controllers.registrations.search.RegistrationSearchApi;
import ua.vehicle.info.api.dto.search.SearchQueryDto;
import ua.vehicle.info.api.dto.search.SearchResults;

/**
 * The type Search rest controller.
 */
@RestController
public class SearchRestController implements RegistrationSearchApi {

    @GetMapping(SEARCH_BY_NUMBER)
    @Override
    public SearchResults findByRegNumber(String registrationNumber) {
        return null;
    }

    @GetMapping(SEARCH_BY_QUERY)
    @Override
    public SearchResults findByQuery(@RequestBody SearchQueryDto queryDto) {
        return null;
    }
}
