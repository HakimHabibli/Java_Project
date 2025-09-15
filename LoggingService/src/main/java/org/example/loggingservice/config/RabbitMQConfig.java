package org.example.loggingservice.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    public static final String LOG_QUEUE = "logQueue";
    public static final String LOG_EXCHANGE = "logExchange";
    public static final String LOG_ROUTING_KEY = "logRoutingKey";


    @Bean
    public Queue logQueue()
    {
        return new Queue(LOG_QUEUE);
    }

    @Bean
    public DirectExchange logExchange()
    {
        return new DirectExchange(LOG_EXCHANGE);
    }

    @Bean
    public Binding logBinding(Queue logQueue, DirectExchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange).with(LOG_ROUTING_KEY);
    }
}
