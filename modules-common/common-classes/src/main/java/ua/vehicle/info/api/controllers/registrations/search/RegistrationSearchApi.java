package ua.vehicle.info.api.controllers.registrations.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.search.SearchQueryDto;
import ua.vehicle.info.api.dto.search.SearchResults;

public interface RegistrationSearchApi {

    String SEARCH_BY_NUMBER = "/registration/{registrationNumber}";
    String SEARCH_BY_QUERY = "/registration";

    @GetMapping(SEARCH_BY_NUMBER)
    SearchResults findByRegNumber(@PathVariable String registrationNumber);

    @GetMapping(SEARCH_BY_QUERY)
    SearchResults findByQuery(@RequestBody SearchQueryDto queryDto);

}
