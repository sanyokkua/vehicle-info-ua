package ua.vehicle.info.events;

import ua.vehicle.info.dto.Status;

public interface ProcessingEventListener {

    void onEvent(Status status, String eventName);
}
