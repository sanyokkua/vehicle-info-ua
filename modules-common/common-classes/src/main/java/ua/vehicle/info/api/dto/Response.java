package ua.vehicle.info.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * The type Response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private HttpStatus status;
    private Object body;
}
