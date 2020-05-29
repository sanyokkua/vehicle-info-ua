package ua.vehicle.info.queues.sender;

import com.google.gson.Gson;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;

/**
 * The type Queue sender service.
 */
@Service
@RequiredArgsConstructor
public class QueueSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final Gson gson;

    /**
     * Send message.
     *
     * @param message the message
     * @param exchange the exchange
     * @param topic the topic
     */
    @LogExceptions
    @SuppressRuntimeExceptions
    public void sendMessage(@NonNull Object message,
            @NonNull QueueExchange exchange,
            @NonNull QueueTopic topic) {
        var json = gson.toJson(message);
        rabbitTemplate.convertAndSend(exchange.getExchange(), topic.getTopic(), json);
    }
}
