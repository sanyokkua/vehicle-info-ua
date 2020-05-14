package ua.vehicle.info.mappers;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.BeforeMapping;
import ua.vehicle.info.dto.RegistrationRecord;

public interface DefaultMapperForRegistrationType<T> extends DefaultMappersForTypes<RegistrationRecord, T> {

    @BeforeMapping
    default void fixSource(RegistrationRecord record) {
        if (Objects.nonNull(record)) {
            var fixedOperName = fixDuplication(record.getOperationName(), String.valueOf(record.getOperationCode()));
            record.setOperationName(fixedOperName);

            var fixedBrand = fixDuplication(record.getVehicleBrand(), record.getVehicleModel());
            record.setVehicleBrand(fixedBrand);
        }
    }

    default String fixDuplication(String source, String duplication) {
        var src = StringUtils.trim(source);
        var fixed = StringUtils.replace(src, duplication, "");
        return StringUtils.trimToEmpty(fixed);
    }
}
