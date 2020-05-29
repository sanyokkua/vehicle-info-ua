package ua.vehicle.info.processing.mappers;

/**
 * The interface Input mapper.
 *
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public interface InputMapper<I, O> {

    /**
     * Map o.
     *
     * @param input the input
     *
     * @return the o
     */
    O map(I input);
}
