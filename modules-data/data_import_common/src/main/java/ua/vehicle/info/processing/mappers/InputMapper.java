package ua.vehicle.info.processing.mappers;

public interface InputMapper<I, O> {

    O map(I input);
}
