package ua.vehicle.info.persist.repository;

public interface InsertFunctionalityRepository<T> {

    <S extends T> S customInsert(S entity);
}
