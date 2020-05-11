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

@Configuration
public class QueueConfig {

    @Bean
    public Queue queue() {
        return new Queue(Queues.QUEUE_ADMIN_UNIT.getQueue(), false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(QueueExchange.VEHICLE_ADMIN_UNIT.getExchange());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(QueueTopic.TOPIC_ADMIN_UNIT.getRoute());
    }
}
