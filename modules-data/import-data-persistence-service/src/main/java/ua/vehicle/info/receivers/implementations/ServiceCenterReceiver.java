package ua.vehicle.info.receivers.implementations;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.listeners.OnMessageListener;
import ua.vehicle.info.receivers.AbstractReceiver;

/**
 * The type Service center receiver.
 */
@Slf4j
@Service
public class ServiceCenterReceiver extends AbstractReceiver<ServiceCenterRecord> {

    /**
     * Instantiates a new Service center receiver.
     *
     * @param gson the gson
     * @param listener the listener
     */
    public ServiceCenterReceiver(Gson gson, OnMessageListener<ServiceCenterRecord> listener) {
        super(gson, listener);
    }

    @LogExceptions
    @SuppressRuntimeExceptions
    @Override
    public ServiceCenterRecord map(String message) {
        return gson.fromJson(message, ServiceCenterRecord.class);
    }
}
