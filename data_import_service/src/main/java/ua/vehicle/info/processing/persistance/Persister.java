package ua.vehicle.info.processing.persistance;

public interface Persister<T> {

    void persist(T input);
}
