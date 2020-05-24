package ua.vehicle.info.persist.chain.vehicle;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.vehicle.VehicleDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.vehicle.VehicleJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

@Slf4j
@Component
public class VehicleDtoHandler extends RegistrationRecordHandler {

    private final VehicleDtoMapper mapper;
    private final VehicleJdbcRepository repository;

    public VehicleDtoHandler(QueueSenderService queueSenderService,
            VehicleDtoMapper mapper, VehicleJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getVehicleId();
        var record = repository.findVehicle(dto);
        if (Objects.isNull(id) && Objects.isNull(record)) {
            repository.customInsert(dto);
        }
    }
}
