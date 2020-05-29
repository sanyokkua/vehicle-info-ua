package ua.vehicle.info.api.controllers.registrations.manage;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.Response;
import ua.vehicle.info.api.dto.authentication.AuthTokenDto;
import ua.vehicle.info.api.dto.search.SearchQueryDto;

/**
 * The interface Search management api.
 * This interface represents all functionality
 * related to saving/loading user queries regarding
 * vehicle registrations.
 */
public interface SearchManagementApi {

    /**
     * Represents save query request path
     */
    String SAVE_QUERY = "/query";
    /**
     * Represents query ID request path
     */
    String QUERY_ID = "/query/{id}";
    /**
     * Represents get all queries request path
     */
    String GET_ALL_QUERIES = "/queries";

    /**
     * Save query.
     *
     * @param queryDto the query dto
     * @param authTokenDto the auth toke dto
     *
     * @return the response
     */
    @PostMapping(SAVE_QUERY)
    Response saveQuery(SearchQueryDto queryDto, @RequestBody AuthTokenDto authTokenDto);

    /**
     * Load query.
     *
     * @param id the id
     * @param authTokenDto the auth toke dto
     *
     * @return the search query dto
     */
    @GetMapping(QUERY_ID)
    SearchQueryDto loadQuery(@PathVariable String id, @RequestBody AuthTokenDto authTokenDto);

    /**
     * Gets all queries.
     *
     * @param authTokenDto the auth toke dto
     *
     * @return the all queries
     */
    @GetMapping(GET_ALL_QUERIES)
    Response getAllQueries(@RequestBody AuthTokenDto authTokenDto);

    /**
     * Delete query.
     *
     * @param id the id
     * @param authTokenDto the auth toke dto
     *
     * @return the response
     */
    @DeleteMapping(QUERY_ID)
    Response deleteQuery(@PathVariable String id, @RequestBody AuthTokenDto authTokenDto);

}
