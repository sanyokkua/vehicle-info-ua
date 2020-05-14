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
import ua.vehicle.info.receivers.implementations.ServiceCenterReceiver;

@Configuration
public class ServiceCenterQueueConfig {

    @Bean("serviceCenterQueue")
    public Queue queue() {
        return new Queue(Queues.QUEUE_SERVICE_CENTER.getQueue(), false);
    }

    @Bean("serviceCenterExchange")
    public TopicExchange exchange() {
        return new TopicExchange(QueueExchange.VEHICLE_SERVICE_CENTER.getExchange());
    }

    @Bean("serviceCenterBinding")
    public Binding binding(@Qualifier("serviceCenterQueue") Queue queue,
            @Qualifier("serviceCenterExchange") TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(QueueTopic.TOPIC_SERVICE_CENTER.getRoute());
    }

    @Bean("serviceCenterContainer")
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
            @Qualifier("serviceCenterListenerAdapter") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(Queues.QUEUE_SERVICE_CENTER.getQueue());
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean("serviceCenterListenerAdapter")
    public MessageListenerAdapter listenerAdapter(ServiceCenterReceiver receiver) {
        return new MessageListenerAdapter(receiver, "process");
    }
}
