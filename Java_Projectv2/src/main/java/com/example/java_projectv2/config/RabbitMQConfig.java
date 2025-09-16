package com.example.java_projectv2.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    //TODO : GOTO YAML +++
    @Value("${my.constant.LOG_QUEUE}")
    public String LOG_QUEUE ;
    @Value("${my.constant.LOG_EXCHANGE}")
    public String LOG_EXCHANGE ;
    @Value("${my.constant.LOG_ROUTING_KEY}")
    public String LOG_ROUTING_KEY ;

    @Bean
    public Queue logQueue() {
        return new Queue(LOG_QUEUE);
    }

    @Bean
    public DirectExchange logExchange() {
        return new DirectExchange(LOG_EXCHANGE  );
    }

    @Bean
    public Binding logBinding(Queue logQueue, DirectExchange logExchange) {
        return BindingBuilder.bind(logQueue).to(logExchange).with(LOG_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate customRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}