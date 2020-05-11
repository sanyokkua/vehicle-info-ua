package ua.vehicle.info.processing;

import lombok.RequiredArgsConstructor;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.ServiceCenter;
import ua.vehicle.info.processing.persistance.Persister;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.sender.QueueSenderService;

@RequiredArgsConstructor
public class ServiceCenterPersister implements Persister<ServiceCenter> {

    private final QueueSenderService queueSenderService;

    @LogExceptions
    @Override
    public void persist(ServiceCenter input) {
        queueSenderService.sendMessage(input, QueueExchange.VEHICLE_SERVICE_CENTER, QueueTopic.TOPIC_SERVICE_CENTER);
    }
}
