package ua.vehicle.info.persist.chain;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogInputOutput;

@Slf4j
public abstract class BaseHandler<T> implements Handler<T> {

    private Handler<T> next;

    @LogInputOutput
    @Override
    public Handler<T> setNext(Handler<T> next) {
        this.next = next;
        return this.next;
    }

    @Override
    public void handle(T obj) {
        try {
            process(obj);
        } catch (Exception ex) {
            log.warn("Exception due processing record {}", obj, ex);
            handleException(obj);
        }
        if (Objects.nonNull(next)) {
            next.handle(obj);
        }
    }

    protected abstract void handleException(T obj);

    protected abstract void process(T obj);
}
