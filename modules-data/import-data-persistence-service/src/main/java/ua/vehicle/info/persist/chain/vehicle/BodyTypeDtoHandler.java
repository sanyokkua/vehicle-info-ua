package ua.vehicle.info.persist.chain.vehicle;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.vehicle.BodyTypeDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.vehicle.BodyTypeJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Body type dto handler.
 */
@Component
public class BodyTypeDtoHandler extends RegistrationRecordHandler {

    private final BodyTypeDtoMapper mapper;
    private final BodyTypeJdbcRepository repository;

    /**
     * Instantiates a new Body type dto handler.
     *
     * @param queueSenderService the queue sender service
     * @param mapper the mapper
     * @param repository the repository
     */
    public BodyTypeDtoHandler(QueueSenderService queueSenderService,
            BodyTypeDtoMapper mapper, BodyTypeJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getBodyName();
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
