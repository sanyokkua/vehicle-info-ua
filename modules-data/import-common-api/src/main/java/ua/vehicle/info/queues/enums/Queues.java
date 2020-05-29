package ua.vehicle.info.queues.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Queues.
 */
@Getter
@AllArgsConstructor
public enum Queues {
    /**
     * Queue admin unit queues.
     */
    QUEUE_ADMIN_UNIT("vehicle-koatuu-queue"),
    /**
     * Queue service center queues.
     */
    QUEUE_SERVICE_CENTER("vehicle-service-center-queue"),
    /**
     * Queue registration queues.
     */
    QUEUE_REGISTRATION("vehicle-registration-queue");

    private final String queue;
}
