package ua.vehicle.info.receivers;

public interface Receiver<T> {

    void process(String message);

    T map(String message);
}
