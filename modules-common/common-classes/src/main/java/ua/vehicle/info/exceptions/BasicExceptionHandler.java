package ua.vehicle.info.exceptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.vehicle.info.api.dto.exceptions.ExceptionResponse;

/**
 * The type Basic exception handler.
 */
public abstract class BasicExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle illegal argument exception response entity.
     *
     * @param ex the ex
     *
     * @return the response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildBasicResponse(ex);
    }

    /**
     * Handle null pointer exception response entity.
     *
     * @param ex the ex
     *
     * @return the response entity
     */
    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ExceptionResponse> handleNullPointerException(NullPointerException ex) {
        return buildBasicResponse(ex);
    }

    /**
     * Handle runtime exception response entity.
     *
     * @param ex the ex
     *
     * @return the response entity
     */
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException ex) {
        return buildBasicResponse(ex);
    }

    /**
     * Handle io exception response entity.
     *
     * @param ex the ex
     *
     * @return the response entity
     */
    @ExceptionHandler(IOException.class)
    protected ResponseEntity<ExceptionResponse> handleIOException(IOException ex) {
        return buildBasicResponse(ex);
    }

    /**
     * Handle exception response entity.
     *
     * @param ex the ex
     *
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        return buildBasicResponse(ex);
    }

    /**
     * Build basic response response entity.
     *
     * @param ex the ex
     *
     * @return the response entity
     */
    protected ResponseEntity<ExceptionResponse> buildBasicResponse(Exception ex) {
        return ResponseEntity
                .badRequest()
                .body(ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .details(ex.toString())
                        .timestamp(LocalDateTime.now())
                        .stackTrace(Stream.of(ex.getStackTrace()).collect(Collectors.toList()))
                        .build());
    }
}

