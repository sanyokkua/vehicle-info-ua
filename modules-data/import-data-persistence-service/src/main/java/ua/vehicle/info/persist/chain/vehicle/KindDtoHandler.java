package ua.vehicle.info.persist.chain.vehicle;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.vehicle.KindDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.vehicle.KindJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Kind dto handler.
 */
@Component
public class KindDtoHandler extends RegistrationRecordHandler {

    private final KindDtoMapper mapper;
    private final KindJdbcRepository repository;

    /**
     * Instantiates a new Kind dto handler.
     *
     * @param queueSenderService the queue sender service
     * @param mapper the mapper
     * @param repository the repository
     */
    public KindDtoHandler(QueueSenderService queueSenderService, KindDtoMapper mapper,
            KindJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getKind();
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
