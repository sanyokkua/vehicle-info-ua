package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.KindDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Kind dto mapper.
 */
@Mapper(componentModel = "spring")
public interface KindDtoMapper extends DefaultMapperForRegistrationType<KindDto> {

    @Mapping(source = "vehicleKind", target = "kind",
            defaultValue = "---")
    @Override
    KindDto map(RegistrationRecord input);
}
