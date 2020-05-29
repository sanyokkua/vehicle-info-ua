package ua.vehicle.info.processing.processor;

/**
 * The interface Task.
 *
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public interface Task<I, O> {

    /**
     * Process o.
     *
     * @param input the input
     *
     * @return the o
     */
    O process(I input);
}
