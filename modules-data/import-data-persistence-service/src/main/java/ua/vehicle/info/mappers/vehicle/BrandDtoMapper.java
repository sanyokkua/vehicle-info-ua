package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.BrandDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

/**
 * The interface Brand dto mapper.
 */
@Mapper(componentModel = "spring")
public interface BrandDtoMapper extends DefaultMapperForRegistrationType<BrandDto> {

    @Mapping(source = "vehicleBrand", target = "brandName",
            defaultValue = "---")
    @Override
    BrandDto map(RegistrationRecord input);
}
