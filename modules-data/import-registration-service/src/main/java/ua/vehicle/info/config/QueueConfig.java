package ua.vehicle.info.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.enums.Queues;

/**
 * The type Queue config.
 */
@Configuration
public class QueueConfig {

    /**
     * Queue queue.
     *
     * @return the queue
     */
    @Bean
    public Queue queue() {
        return new Queue(Queues.QUEUE_REGISTRATION.getQueue(), false);
    }

    /**
     * Exchange topic exchange.
     *
     * @return the topic exchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(QueueExchange.VEHICLE_REGISTRATION.getExchange());
    }

    /**
     * Binding binding.
     *
     * @param queue the queue
     * @param exchange the exchange
     *
     * @return the binding
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(QueueTopic.TOPIC_REGISTRATION.getRoute());
    }
}
