package ua.vehicle.info.processing;

import lombok.RequiredArgsConstructor;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.sender.QueueSenderService;

@RequiredArgsConstructor
public class AdminUnitPersister implements Persister<AdminUnitRecord> {

    private final QueueSenderService queueSenderService;

    @LogExceptions
    @Override
    public void persist(AdminUnitRecord input) {
        queueSenderService.sendMessage(input, QueueExchange.VEHICLE_ADMIN_UNIT, QueueTopic.TOPIC_ADMIN_UNIT);
    }
}
