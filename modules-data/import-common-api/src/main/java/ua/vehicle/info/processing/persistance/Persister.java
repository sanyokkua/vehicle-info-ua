package ua.vehicle.info.processing.persistance;

/**
 * The interface Persister.
 *
 * @param <T> the type parameter
 */
public interface Persister<T> {

    /**
     * Persist.
     *
     * @param input the input
     */
    void persist(T input);
}
