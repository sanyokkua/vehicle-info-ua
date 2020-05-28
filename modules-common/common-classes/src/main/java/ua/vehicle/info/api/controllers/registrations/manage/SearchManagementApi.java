package ua.vehicle.info.api.controllers.registrations.manage;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.vehicle.info.api.dto.Response;
import ua.vehicle.info.api.dto.authentication.AuthTokeDto;
import ua.vehicle.info.api.dto.search.SearchQueryDto;

public interface SearchManagementApi {

    String SAVE_QUERY = "/query";
    String QUERY_ID = "/query/{id}";
    String GET_ALL_QUERIES = "/queries";

    @PostMapping(SAVE_QUERY)
    Response saveQuery(SearchQueryDto queryDto, @RequestBody AuthTokeDto authTokeDto);

    @GetMapping(QUERY_ID)
    SearchQueryDto loadQuery(@PathVariable String id, @RequestBody AuthTokeDto authTokeDto);

    @GetMapping(GET_ALL_QUERIES)
    Response getAllQueries(@RequestBody AuthTokeDto authTokeDto);

    @DeleteMapping(QUERY_ID)
    Response deleteQuery(@PathVariable String id, @RequestBody AuthTokeDto authTokeDto);

}
