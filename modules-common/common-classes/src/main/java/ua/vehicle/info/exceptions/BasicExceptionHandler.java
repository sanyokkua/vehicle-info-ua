package ua.vehicle.info.exceptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.vehicle.info.api.dto.exceptions.ExceptionResponse;

public abstract class BasicExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildBasicResponse(ex);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ExceptionResponse> handleNullPointerException(NullPointerException ex) {
        return buildBasicResponse(ex);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException ex) {
        return buildBasicResponse(ex);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<ExceptionResponse> handleIOException(IOException ex) {
        return buildBasicResponse(ex);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        return buildBasicResponse(ex);
    }

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

