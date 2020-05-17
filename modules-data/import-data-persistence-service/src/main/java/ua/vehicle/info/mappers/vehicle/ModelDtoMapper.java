package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.ModelDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

@Mapper(componentModel = "spring")
public interface ModelDtoMapper extends DefaultMapperForRegistrationType<ModelDto> {

    @Mapping(source = "vehicleModel", target = "modelName",
            defaultValue = "---")
    @Override
    ModelDto map(RegistrationRecord input);
}
