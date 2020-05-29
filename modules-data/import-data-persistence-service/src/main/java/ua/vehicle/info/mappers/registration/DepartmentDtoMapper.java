package ua.vehicle.info.mappers.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.registration.DepartmentDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Department dto mapper.
 */
@Mapper(componentModel = "spring")
public interface DepartmentDtoMapper extends DefaultMapperForRegistrationType<DepartmentDto> {

    @Mapping(source = "departmentCode", target = "depCode")
    @Mapping(source = "departmentName", target = "depName")
    @Override
    DepartmentDto map(RegistrationRecord input);

}
