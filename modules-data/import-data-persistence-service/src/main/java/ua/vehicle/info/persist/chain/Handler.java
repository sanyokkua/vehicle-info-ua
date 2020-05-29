package ua.vehicle.info.persist.chain;

/**
 * The interface Handler.
 *
 * @param <T> the type parameter
 */
public interface Handler<T> {

    /**
     * Sets next.
     *
     * @param next the next
     *
     * @return the next
     */
    Handler<T> setNext(Handler<T> next);

    /**
     * Handle.
     *
     * @param obj the obj
     */
    void handle(T obj);
}
