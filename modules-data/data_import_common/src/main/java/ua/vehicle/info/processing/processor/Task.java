package ua.vehicle.info.processing.processor;

public interface Task<I, O> {

    O process(I input);
}
