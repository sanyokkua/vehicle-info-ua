package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.ColorDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Color dto mapper.
 */
@Mapper(componentModel = "spring")
public interface ColorDtoMapper extends DefaultMapperForRegistrationType<ColorDto> {

    @Mapping(source = "vehicleColor", target = "colorName",
            defaultValue = "---")
    @Override
    ColorDto map(RegistrationRecord input);
}
