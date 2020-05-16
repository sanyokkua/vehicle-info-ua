package ua.vehicle.info.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.apache.commons.lang3.StringUtils;
import ua.vehicle.info.processing.mappers.InputMapper;

public interface DefaultMappersForTypes<I, O> extends InputMapper<I, O> {

    default Integer intFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    default LocalDate dateFromString(String input) {
        var formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd.MM.yyyy]");
        try {
            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    default String upperCase(String input) {
        if (StringUtils.isBlank(input)) {
            return StringUtils.EMPTY;
        }
        var trimmed = StringUtils.trim(input);
        return StringUtils.upperCase(trimmed);
    }
}
