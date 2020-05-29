package ua.vehicle.info.mappers.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.dto.registration.ServiceCenterDto;
import ua.vehicle.info.mappers.DefaultMappersForTypes;

/**
 * The interface Service center dto mapper.
 */
@Mapper(componentModel = "spring")
public interface ServiceCenterDtoMapper extends DefaultMappersForTypes<ServiceCenterRecord, ServiceCenterDto> {

    @Mapping(source = "centerNumber", target = "centerNumber")
    @Mapping(source = "address", target = "address",
            defaultValue = "---")
    @Mapping(source = "email", target = "email",
            defaultValue = "---")
    @Override
    ServiceCenterDto map(ServiceCenterRecord input);
}
