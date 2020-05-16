package ua.vehicle.info.queues.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueueTopic {
    TOPIC_ADMIN_UNIT("ua.vehicle.info.koatuu"),
    TOPIC_SERVICE_CENTER("ua.vehicle.info.service.center"),
    TOPIC_REGISTRATION("ua.vehicle.info.registration");

    private final String topic;

    public String getRoute() {
        return String.format("%s.#", topic);
    }
}
