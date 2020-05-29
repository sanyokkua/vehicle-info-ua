package ua.vehicle.info.events;

import ua.vehicle.info.api.dto.processing.Status;

/**
 * The interface Processing event listener.
 */
public interface ProcessingEventListener {

    /**
     * On event.
     *
     * @param status the status
     * @param eventName the event name
     */
    void onEvent(Status status, String eventName);
}
