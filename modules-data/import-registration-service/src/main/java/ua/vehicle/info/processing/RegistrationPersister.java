package ua.vehicle.info.processing;

import lombok.RequiredArgsConstructor;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Registration persister.
 */
@RequiredArgsConstructor
public class RegistrationPersister implements Persister<RegistrationRecord> {

    private final QueueSenderService queueSenderService;

    @LogExceptions
    @Override
    public void persist(RegistrationRecord input) {
        queueSenderService.sendMessage(input, QueueExchange.VEHICLE_REGISTRATION, QueueTopic.TOPIC_REGISTRATION);
    }
}
