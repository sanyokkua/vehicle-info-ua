package ua.vehicle.info.listeners;

/**
 * The interface On message listener.
 *
 * @param <T> the type parameter
 */
public interface OnMessageListener<T> {

    /**
     * On message.
     *
     * @param message the message
     */
    void onMessage(T message);
}
