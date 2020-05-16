package ua.vehicle.info.mappers.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.dto.registration.AdminUnitDto;
import ua.vehicle.info.mappers.DefaultMappersForTypes;

@Mapper(componentModel = "spring")
public interface AdminUnitDtoMapper extends DefaultMappersForTypes<AdminUnitRecord, AdminUnitDto> {

    @Mapping(source = "firstLevel", target = "level1Code",
            defaultValue = "---")
    @Mapping(source = "secondLevel", target = "level2Code",
            defaultValue = "---")
    @Mapping(source = "thirdLevel", target = "level3Code",
            defaultValue = "---")
    @Mapping(source = "fourthLevel", target = "level4Code",
            defaultValue = "---")
    @Mapping(source = "category", target = "category",
            defaultValue = "---")
    @Mapping(source = "name", target = "name",
            defaultValue = "---")
    @Override
    AdminUnitDto map(AdminUnitRecord record);
}
