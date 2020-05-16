package ua.vehicle.info.queues.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueueExchange {
    VEHICLE_ADMIN_UNIT("vehicle-koatuu-exchange"),
    VEHICLE_SERVICE_CENTER("vehicle-service-center-exchange"),
    VEHICLE_REGISTRATION("vehicle-registration-exchange");

    private final String exchange;
}
