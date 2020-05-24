package ua.vehicle.info.persist.chain.vehicle;

import java.util.Objects;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.mappers.vehicle.ColorDtoMapper;
import ua.vehicle.info.persist.chain.RegistrationRecordHandler;
import ua.vehicle.info.persist.repository.vehicle.ColorJdbcRepository;
import ua.vehicle.info.queues.sender.QueueSenderService;

@Component
public class ColorDtoHandler extends RegistrationRecordHandler {

    private final ColorDtoMapper mapper;
    private final ColorJdbcRepository repository;

    public ColorDtoHandler(QueueSenderService queueSenderService, ColorDtoMapper mapper,
            ColorJdbcRepository repository) {
        super(queueSenderService);
        this.mapper = mapper;
        this.repository = repository;
    }

    @LogExceptions
    @Override
    protected void process(RegistrationRecord obj) {
        var dto = mapper.map(obj);
        var id = dto.getColorName();
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
