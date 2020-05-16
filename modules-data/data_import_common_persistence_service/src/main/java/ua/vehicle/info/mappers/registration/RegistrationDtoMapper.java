package ua.vehicle.info.mappers.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.registration.RegistrationDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

@Mapper(componentModel = "spring")
public interface RegistrationDtoMapper extends DefaultMapperForRegistrationType<RegistrationDto> {

    @Mapping(source = "vehiclePurpose", target = "purpose")
    @Mapping(source = "departmentCode", target = "depCode")
    @Mapping(source = "administrativeTerritorialUnitCode", target = "adminUnit",
            defaultValue = "---")
    @Mapping(source = "operationCode", target = "operCode")
    @Mapping(source = "registrationDate", target = "regDate")
    @Mapping(source = "personType", target = "personType")
    @Mapping(source = "registrationNumber", target = "regNumber")
    @Override
    RegistrationDto map(RegistrationRecord input);
}
