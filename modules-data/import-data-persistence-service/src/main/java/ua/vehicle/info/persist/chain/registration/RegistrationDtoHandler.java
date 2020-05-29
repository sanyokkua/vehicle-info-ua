package ua.vehicle.info.persist.chain.registration;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.registration.RegistrationDtoMapper;
import ua.vehicle.info.mappers.vehicle.VehicleDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.registration.RegistrationJdbcRepository;
import ua.vehicle.info.persist.repository.vehicle.VehicleJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Registration dto handler.
 */
@Slf4j
@Component
public class RegistrationDtoHandler extends RegistrationRecordHandler {

    private final RegistrationDtoMapper mapper;
    private final VehicleDtoMapper vehicleDtoMapper;
    private final RegistrationJdbcRepository repository;
    private final VehicleJdbcRepository vehicleJdbcRepository;

    /**
     * Instantiates a new Registration dto handler.
     *
     * @param queueSenderService the queue sender service
     * @param mapper the mapper
     * @param vehicleDtoMapper the vehicle dto mapper
     * @param repository the repository
     * @param vehicleJdbcRepository the vehicle jdbc repository
     */
    public RegistrationDtoHandler(QueueSenderService queueSenderService,
            RegistrationDtoMapper mapper, VehicleDtoMapper vehicleDtoMapper,
            RegistrationJdbcRepository repository,
            VehicleJdbcRepository vehicleJdbcRepository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.vehicleDtoMapper = vehicleDtoMapper;
        this.repository = repository;
        this.vehicleJdbcRepository = vehicleJdbcRepository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var vehicleDto = vehicleDtoMapper.map(obj);
        var vehicleFromDb = vehicleJdbcRepository.findVehicle(vehicleDto);
        dto.setVehicleId(vehicleFromDb.getVehicleId());

        var id = dto.getRegId();
        var record = repository.findRegistration(dto);
        if (Objects.isNull(id) && Objects.isNull(record)) {
            repository.customInsert(dto);
        }
    }
}
