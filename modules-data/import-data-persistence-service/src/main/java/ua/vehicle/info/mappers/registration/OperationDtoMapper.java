package ua.vehicle.info.mappers.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.registration.OperationDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Operation dto mapper.
 */
@Mapper(componentModel = "spring")
public interface OperationDtoMapper extends DefaultMapperForRegistrationType<OperationDto> {

    @Mapping(source = "operationCode", target = "opCode")
    @Mapping(source = "operationName", target = "description")
    @Override
    OperationDto map(RegistrationRecord input);

}
