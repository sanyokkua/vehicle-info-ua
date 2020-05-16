package ua.vehicle.info.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.info.queues.enums.QueueExchange;
import ua.vehicle.info.queues.enums.QueueTopic;
import ua.vehicle.info.queues.enums.Queues;
import ua.vehicle.info.receivers.implementations.AdminUnitReceiver;

@Configuration
public class AdminUnitQueueConfig {

    @Bean("adminUnitQueue")
    public Queue queue() {
        return new Queue(Queues.QUEUE_ADMIN_UNIT.getQueue(), false);
    }

    @Bean("adminUnitExchange")
    public TopicExchange exchange() {
        return new TopicExchange(QueueExchange.VEHICLE_ADMIN_UNIT.getExchange());
    }

    @Bean("adminUnitBinding")
    public Binding binding(@Qualifier("adminUnitQueue") Queue queue,
            @Qualifier("adminUnitExchange") TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(QueueTopic.TOPIC_ADMIN_UNIT.getRoute());
    }

    @Bean("adminUnitContainer")
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
            @Qualifier("adminUnitListenerAdapter") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(Queues.QUEUE_ADMIN_UNIT.getQueue());
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean("adminUnitListenerAdapter")
    public MessageListenerAdapter listenerAdapter(AdminUnitReceiver receiver) {
        return new MessageListenerAdapter(receiver, "process");
    }
}
