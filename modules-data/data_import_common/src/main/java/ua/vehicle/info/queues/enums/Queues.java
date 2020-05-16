package ua.vehicle.info.queues.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Queues {
    QUEUE_ADMIN_UNIT("vehicle-koatuu-queue"),
    QUEUE_SERVICE_CENTER("vehicle-service-center-queue"),
    QUEUE_REGISTRATION("vehicle-registration-queue");

    private final String queue;
}
