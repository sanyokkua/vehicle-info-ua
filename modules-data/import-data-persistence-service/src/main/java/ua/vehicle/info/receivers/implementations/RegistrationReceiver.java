package ua.vehicle.info.receivers.implementations;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.listeners.OnMessageListener;
import ua.vehicle.info.receivers.AbstractReceiver;

/**
 * The type Registration receiver.
 */
@Slf4j
@Service
public class RegistrationReceiver extends AbstractReceiver<RegistrationRecord> {

    /**
     * Instantiates a new Registration receiver.
     *
     * @param gson the gson
     * @param listener the listener
     */
    public RegistrationReceiver(Gson gson, OnMessageListener<RegistrationRecord> listener) {
        super(gson, listener);
    }

    @LogExceptions
    @SuppressRuntimeExceptions
    @Override
    public RegistrationRecord map(String message) {
        return gson.fromJson(message, RegistrationRecord.class);
    }
}
