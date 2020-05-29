package ua.vehicle.info.receivers.implementations;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.listeners.OnMessageListener;
import ua.vehicle.info.receivers.AbstractReceiver;

/**
 * The type Admin unit receiver.
 */
@Slf4j
@Service
public class AdminUnitReceiver extends AbstractReceiver<AdminUnitRecord> {

    /**
     * Instantiates a new Admin unit receiver.
     *
     * @param gson the gson
     * @param listener the listener
     */
    public AdminUnitReceiver(Gson gson, OnMessageListener<AdminUnitRecord> listener) {
        super(gson, listener);
    }

    @LogExceptions
    @SuppressRuntimeExceptions
    @Override
    public AdminUnitRecord map(String message) {
        return gson.fromJson(message, AdminUnitRecord.class);
    }
}
