package ua.vehicle.info.api.dto.processing;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Processing status.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessingStatus {

    private Status status;
    private LocalDateTime startTime;
    private LocalDateTime currentTime;
}
