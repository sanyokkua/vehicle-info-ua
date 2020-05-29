package ua.vehicle.info.persist.chain.vehicle;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.vehicle.ModelDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.vehicle.ModelJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Model dto handler.
 */
@Component
public class ModelDtoHandler extends RegistrationRecordHandler {

    private final ModelDtoMapper mapper;
    private final ModelJdbcRepository repository;

    /**
     * Instantiates a new Model dto handler.
     *
     * @param queueSenderService the queue sender service
     * @param mapper the mapper
     * @param repository the repository
     */
    public ModelDtoHandler(QueueSenderService queueSenderService, ModelDtoMapper mapper,
            ModelJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getModelName();
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
