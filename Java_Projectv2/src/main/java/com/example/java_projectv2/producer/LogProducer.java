package com.example.java_projectv2.producer;


import com.example.java_projectv2.dto.log.LogDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogProducer
{

    public static final String LOG_EXCHANGE = "logExchange";
    public static final String LOG_ROUTING_KEY = "logRoutingKey";
    private final AmqpTemplate amqpTemplate;

    public LogProducer(@Qualifier("customRabbitTemplate")AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendLog(LogDto log)
    {
        amqpTemplate.convertAndSend(LOG_EXCHANGE, LOG_ROUTING_KEY, log);
    }
}
