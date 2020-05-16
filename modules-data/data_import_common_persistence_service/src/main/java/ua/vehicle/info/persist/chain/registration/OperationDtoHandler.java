package ua.vehicle.info.persist.chain.registration;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.registration.OperationDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.registration.OperationJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

@Component
public class OperationDtoHandler extends RegistrationRecordHandler {

    private final OperationDtoMapper mapper;
    private final OperationJdbcRepository repository;

    public OperationDtoHandler(QueueSenderService queueSenderService,
            OperationDtoMapper mapper,
            OperationJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getOpCode();
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
