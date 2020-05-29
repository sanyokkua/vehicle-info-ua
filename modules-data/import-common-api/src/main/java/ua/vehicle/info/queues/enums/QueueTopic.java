package ua.vehicle.info.queues.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Queue topic.
 */
@Getter
@AllArgsConstructor
public enum QueueTopic {
    /**
     * Topic admin unit queue topic.
     */
    TOPIC_ADMIN_UNIT("ua.vehicle.info.koatuu"),
    /**
     * Topic service center queue topic.
     */
    TOPIC_SERVICE_CENTER("ua.vehicle.info.service.center"),
    /**
     * Topic registration queue topic.
     */
    TOPIC_REGISTRATION("ua.vehicle.info.registration");

    private final String topic;

    /**
     * Gets route.
     *
     * @return the route
     */
    public String getRoute() {
        return String.format("%s.#", topic);
    }
}
