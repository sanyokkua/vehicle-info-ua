package ua.vehicle.info.persist.chain;

public interface Handler<T> {

    Handler<T> setNext(Handler<T> next);

    void handle(T obj);
}
