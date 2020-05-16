package ua.vehicle.info.mappers.vehicle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.dto.vehicle.VehicleDto;
import ua.vehicle.info.mappers.DefaultMapperForRegistrationType;

@Mapper(componentModel = "spring")
public interface VehicleDtoMapper extends DefaultMapperForRegistrationType<VehicleDto> {

    @Mapping(source = "vehicleBrand", target = "brand",
            defaultValue = "---")
    @Mapping(source = "vehicleModel", target = "model",
            defaultValue = "---")
    @Mapping(source = "vehicleBody", target = "body",
            defaultValue = "---")
    @Mapping(source = "vehicleKind", target = "kind",
            defaultValue = "---")
    @Mapping(source = "vehicleFuelType", target = "fuel",
            defaultValue = "---")
    @Mapping(source = "vehicleColor", target = "color",
            defaultValue = "---")
    @Mapping(source = "capacity", target = "engineCapacity")
    @Mapping(source = "vehicleMakeYear", target = "makeYear")
    @Mapping(source = "vehicleOwnWeight", target = "ownWeight")
    @Mapping(source = "vehicleTotalWeight", target = "totalWeight")
    @Override
    VehicleDto map(RegistrationRecord input);
}
