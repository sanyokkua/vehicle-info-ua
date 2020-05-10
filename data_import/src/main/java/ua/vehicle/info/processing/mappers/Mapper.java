package ua.vehicle.info.processing.mappers;

public interface Mapper<I, O> {

    O map(I input);
}
