package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.BodyTypeDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

@Mapper(componentModel = "spring")
public interface BodyTypeDtoMapper extends DefaultMapperForRegistrationType<BodyTypeDto> {

    @Mapping(source = "vehicleBody", target = "bodyName",
            defaultValue = "---")
    @Override
    BodyTypeDto map(RegistrationRecord input);
}
