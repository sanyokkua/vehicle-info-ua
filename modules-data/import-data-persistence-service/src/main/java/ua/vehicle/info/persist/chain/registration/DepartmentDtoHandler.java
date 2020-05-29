package ua.vehicle.info.persist.chain.registration;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.registration.DepartmentDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.registration.DepartmentJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Department dto handler.
 */
@Component
public class DepartmentDtoHandler extends RegistrationRecordHandler {

    private final DepartmentDtoMapper mapper;
    private final DepartmentJdbcRepository repository;

    /**
     * Instantiates a new Department dto handler.
     *
     * @param queueSenderService the queue sender service
     * @param mapper the mapper
     * @param repository the repository
     */
    public DepartmentDtoHandler(QueueSenderService queueSenderService,
            DepartmentDtoMapper mapper,
            DepartmentJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getDepCode();
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
