package ua.vehicle.info.events;

import ua.vehicle.info.api.dto.processing.Status;

public interface ProcessingEventListener {

    void onEvent(Status status, String eventName);
}
