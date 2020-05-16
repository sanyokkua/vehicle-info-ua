package ua.vehicle.info.receivers;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.listeners.OnMessageListener;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractReceiver<T> implements Receiver<T> {

    protected final Gson gson;
    protected final OnMessageListener<T> listener;

    @LogExceptions
    @SuppressRuntimeExceptions
    @Override
    public void process(String message) {
        var dto = map(message);
        listener.onMessage(dto);
    }

}
