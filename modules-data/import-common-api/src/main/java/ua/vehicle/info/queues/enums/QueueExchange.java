package ua.vehicle.info.queues.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Queue exchange.
 */
@Getter
@AllArgsConstructor
public enum QueueExchange {
    /**
     * Vehicle admin unit queue exchange.
     */
    VEHICLE_ADMIN_UNIT("vehicle-koatuu-exchange"),
    /**
     * Vehicle service center queue exchange.
     */
    VEHICLE_SERVICE_CENTER("vehicle-service-center-exchange"),
    /**
     * Vehicle registration queue exchange.
     */
    VEHICLE_REGISTRATION("vehicle-registration-exchange");

    private final String exchange;
}
