package ua.vehicle.info.persist.repository;

/**
 * The interface Insert functionality repository.
 *
 * @param <T> the type parameter
 */
public interface InsertFunctionalityRepository<T> {

    /**
     * Custom insert s.
     *
     * @param <S> the type parameter
     * @param entity the entity
     *
     * @return the s
     */
    <S extends T> S customInsert(S entity);
}
