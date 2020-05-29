package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.FuelTypeDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Fuel type dto mapper.
 */
@Mapper(componentModel = "spring")
public interface FuelTypeDtoMapper extends DefaultMapperForRegistrationType<FuelTypeDto> {

    @Mapping(source = "vehicleFuelType", target = "fuelName",
            defaultValue = "---")
    @Override
    FuelTypeDto map(RegistrationRecord input);
}
