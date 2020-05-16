package ua.vehicle.info.persist.chain.vehicle;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.vehicle.FuelTypeDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.vehicle.FuelTypeJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

@Component
public class FuelTypeDtoHandler extends RegistrationRecordHandler {

    private final FuelTypeDtoMapper mapper;
    private final FuelTypeJdbcRepository repository;

    public FuelTypeDtoHandler(QueueSenderService queueSenderService,
            FuelTypeDtoMapper mapper, FuelTypeJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getFuelName();
        if (Objects.nonNull(id)) {
            var exists = repository.existsById(id);
            if (!exists) {
                repository.customInsert(dto);
            }
        } else {
            repository.customInsert(dto);
        }
    }
}
