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

@Getter
@Setter
public abstract class Processor {

    protected ProcessingEventListener listener;

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

    protected abstract void runSteps(URL url);

    protected void notifyListener(Status status) {
        notifyListener(status, status.toString());
    }

    protected void notifyListener(Status status, String eventName) {
        if (Objects.nonNull(listener)) {
            listener.onEvent(status, eventName);
        }
    }

}
