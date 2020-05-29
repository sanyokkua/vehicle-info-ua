package ua.vehicle.info.controllers;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Getter;
import ua.vehicle.info.api.controllers.processing.ProcessingControllerApi;
import ua.vehicle.info.api.dto.processing.ProcessingStatus;
import ua.vehicle.info.api.dto.processing.Status;
import ua.vehicle.info.events.ProcessingEventListener;

/**
 * The type Abstract processing controller.
 */
public abstract class AbstractProcessingController implements ProcessingControllerApi {

    /**
     * The Event listener.
     */
    protected final EventListener eventListener = new EventListener();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * Start processing status.
     *
     * @param runnable the runnable
     *
     * @return the processing status
     */
    protected ProcessingStatus start(Runnable runnable) {
        if (eventListener.getCurrentStatus() != Status.RUNNING) {
            executorService.submit(runnable);
        }
        return buildStatus();
    }

    /**
     * Build status processing status.
     *
     * @return the processing status
     */
    protected ProcessingStatus buildStatus() {
        return ProcessingStatus.builder()
                .currentTime(LocalDateTime.now())
                .status(eventListener.getCurrentStatus())
                .startTime(eventListener.getStarted())
                .build();
    }

    @Getter
    private static class EventListener implements ProcessingEventListener {

        private Status currentStatus = Status.NOT_STARTED;
        private String eventName;
        private LocalDateTime started;

        @Override
        public void onEvent(Status updatedStatus, String eventName) {
            if (this.currentStatus != Status.RUNNING && updatedStatus == Status.RUNNING) {
                this.started = LocalDateTime.now();
            }
            this.currentStatus = updatedStatus;
            this.eventName = eventName;
        }
    }
}
