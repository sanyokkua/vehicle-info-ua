package ua.vehicle.info.mappers.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.registration.PurposeDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Purpose dto mapper.
 */
@Mapper(componentModel = "spring")
public interface PurposeDtoMapper extends DefaultMapperForRegistrationType<PurposeDto> {

    @Mapping(source = "vehiclePurpose", target = "purpose",
            defaultValue = "---")
    @Override
    PurposeDto map(RegistrationRecord input);
}
