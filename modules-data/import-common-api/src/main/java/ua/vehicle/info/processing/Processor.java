package ua.vehicle.info.processing;

import java.net.URL;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import ua.vehicle.info.api.dto.processing.Status;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.LogTimeMeasures;
import ua.vehicle.info.events.ProcessingEventListener;

/**
 * The type Processor.
 */
@Getter
@Setter
public abstract class Processor {

    /**
     * The Listener.
     */
    protected ProcessingEventListener listener;

    /**
     * Processing boolean.
     *
     * @param url the url
     *
     * @return the boolean
     */
    @LogInputOutput
    @LogExceptions
    @LogTimeMeasures
    public Boolean processing(URL url) {
        notifyListener(Status.NOT_STARTED);
        try {
            notifyListener(Status.RUNNING);
            runSteps(url);
            notifyListener(Status.FINISHED);
        } catch (Exception ex) {
            notifyListener(Status.CRASHED, "Processing stopped because of Exception");
            return false;
        }
        return true;
    }

    /**
     * Run steps.
     *
     * @param url the url
     */
    protected abstract void runSteps(URL url);

    /**
     * Notify listener.
     *
     * @param status the status
     */
    protected void notifyListener(Status status) {
        notifyListener(status, status.toString());
    }

    /**
     * Notify listener.
     *
     * @param status the status
     * @param eventName the event name
     */
    protected void notifyListener(Status status, String eventName) {
        if (Objects.nonNull(listener)) {
            listener.onEvent(status, eventName);
        }
    }

}
