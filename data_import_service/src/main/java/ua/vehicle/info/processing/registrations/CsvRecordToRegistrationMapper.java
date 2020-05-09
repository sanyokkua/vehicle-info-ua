package ua.vehicle.info.processing.registrations;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.info.aspects.LogOnlyException;
import ua.vehicle.info.dto.registration.RegistrationRecord;
import ua.vehicle.info.processing.mappers.Mapper;

@RequiredArgsConstructor
@Slf4j
public class CsvRecordToRegistrationMapper implements Mapper<CSVRecord, RegistrationRecord> {

    private final Gson gson;

    @LogOnlyException
    @Override
    public RegistrationRecord map(CSVRecord input) {
        var recordAsMap = input.toMap();
        var filteredMap = new HashMap<String, String>();
        recordAsMap.forEach((key, value) -> {
            var normalizedValue = normalize(value);
            filteredMap.put(key, normalizedValue);
        });
        var json = gson.toJson(filteredMap);
        return gson.fromJson(json, RegistrationRecord.class);
    }

    @LogOnlyException
    private String normalize(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        if ("NULL".equalsIgnoreCase(value)) {
            return null;
        }
        return value.toUpperCase();
    }
}
