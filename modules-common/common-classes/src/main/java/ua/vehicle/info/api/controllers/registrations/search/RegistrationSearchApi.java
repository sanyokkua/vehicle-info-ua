package ua.vehicle.info.api.controllers.registrations.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.search.SearchQueryDto;
import ua.vehicle.info.api.dto.search.SearchResults;

/**
 * The interface Registration search api.
 * This interface represents all functionality
 * related to searching vehicle registrations.
 */
public interface RegistrationSearchApi {

    /**
     * Represents search by number request path
     */
    String SEARCH_BY_NUMBER = "/registration/{registrationNumber}";
    /**
     * Represents search by query request path
     */
    String SEARCH_BY_QUERY = "/registration";

    /**
     * Searching registrations for given reg_number
     *
     * @param registrationNumber the registration number
     *
     * @return the search results
     */
    @GetMapping(SEARCH_BY_NUMBER)
    SearchResults findByRegNumber(@PathVariable String registrationNumber);

    /**
     * Searching registrations for given query
     *
     * @param queryDto the query dto
     *
     * @return the search results
     */
    @GetMapping(SEARCH_BY_QUERY)
    SearchResults findByQuery(@RequestBody SearchQueryDto queryDto);

}
