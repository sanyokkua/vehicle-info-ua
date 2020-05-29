package ua.vehicle.info.receivers;

/**
 * The interface Receiver.
 *
 * @param <T> the type parameter
 */
public interface Receiver<T> {

    /**
     * Process.
     *
     * @param message the message
     */
    void process(String message);

    /**
     * Map t.
     *
     * @param message the message
     *
     * @return the t
     */
    T map(String message);
}
