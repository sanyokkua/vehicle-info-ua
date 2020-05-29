package ua.vehicle.info.persist.chain.registration;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.registration.PurposeDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.registration.PurposeJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Purpose dto handler.
 */
@Component
public class PurposeDtoHandler extends RegistrationRecordHandler {

    private final PurposeDtoMapper mapper;
    private final PurposeJdbcRepository repository;

    /**
     * Instantiates a new Purpose dto handler.
     *
     * @param queueSenderService the queue sender service
     * @param mapper the mapper
     * @param repository the repository
     */
    public PurposeDtoHandler(QueueSenderService queueSenderService,
            PurposeDtoMapper mapper, PurposeJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getPurpose();
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
