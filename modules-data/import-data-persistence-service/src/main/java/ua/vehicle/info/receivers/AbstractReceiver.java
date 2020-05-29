package ua.vehicle.info.receivers;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.listeners.OnMessageListener;

/**
 * The type Abstract receiver.
 *
 * @param <T> the type parameter
 */
@Slf4j
@RequiredArgsConstructor
public abstract class AbstractReceiver<T> implements Receiver<T> {

    /**
     * The Gson.
     */
    protected final Gson gson;
    /**
     * The Listener.
     */
    protected final OnMessageListener<T> listener;

    @LogExceptions
    @SuppressRuntimeExceptions
    @Override
    public void process(String message) {
        var dto = map(message);
        listener.onMessage(dto);
    }

}
