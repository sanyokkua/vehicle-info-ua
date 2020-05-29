package ua.vehicle.info.processing;

import lombok.RequiredArgsConstructor;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.sender.QueueSenderService;

/**
 * The type Service center persister.
 */
@RequiredArgsConstructor
public class ServiceCenterPersister implements Persister<ServiceCenterRecord> {

    private final QueueSenderService queueSenderService;

    @LogExceptions
    @Override
    public void persist(ServiceCenterRecord input) {
        queueSenderService.sendMessage(input, QueueExchange.VEHICLE_SERVICE_CENTER, QueueTopic.TOPIC_SERVICE_CENTER);
    }
}
