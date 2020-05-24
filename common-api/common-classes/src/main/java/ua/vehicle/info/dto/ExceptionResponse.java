package ua.vehicle.info.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExceptionResponse extends Response {

    private String message;
    private String details;
    private String path;
    private LocalDateTime timestamp;
    private Throwable exception;
    private List<StackTraceElement> stackTrace;
}
