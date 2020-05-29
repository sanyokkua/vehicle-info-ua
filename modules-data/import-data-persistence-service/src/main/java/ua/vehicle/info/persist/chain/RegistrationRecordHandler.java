package ua.vehicle.info.persist.chain;

import lombok.RequiredArgsConstructor;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Registration record handler.
 */
@RequiredArgsConstructor
public abstract class RegistrationRecordHandler extends BaseHandler<RegistrationRecord> {

    private final QueueSenderService queueSenderService;

    @LogExceptions
    @Override
    protected void handleException(RegistrationRecord obj) {
        queueSenderService.sendMessage(obj, QueueExchange.VEHICLE_REGISTRATION, QueueTopic.TOPIC_REGISTRATION);
    }
}
