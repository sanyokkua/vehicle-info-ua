package ua.vehicle.info.mappers;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.BeforeMapping;
import ua.vehicle.info.dto.RegistrationRecord;

/**
 * The interface Default mapper for registration type.
 *
 * @param <T> the type parameter
 */
public interface DefaultMapperForRegistrationType<T> extends DefaultMappersForTypes<RegistrationRecord, T> {

    /**
     * Fix source.
     *
     * @param record the record
     */
    @BeforeMapping
    default void fixSource(RegistrationRecord record) {
        if (Objects.nonNull(record)) {
            var fixedOperName = fixDuplication(record.getOperationName(), String.valueOf(record.getOperationCode()));
            record.setOperationName(fixedOperName);

            var fixedBrand = fixDuplication(record.getVehicleBrand(), record.getVehicleModel());
            record.setVehicleBrand(fixedBrand);
        }
    }

    /**
     * Fix duplication string.
     *
     * @param source the source
     * @param duplication the duplication
     *
     * @return the string
     */
    default String fixDuplication(String source, String duplication) {
        var src = StringUtils.trim(source);
        var fixed = StringUtils.replace(src, duplication.trim(), "");
        return StringUtils.trimToEmpty(fixed);
    }
}
