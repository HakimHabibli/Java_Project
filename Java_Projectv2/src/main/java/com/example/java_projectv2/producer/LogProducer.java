package com.example.java_projectv2.producer;


import com.example.java_projectv2.dto.log.LogDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogProducer
{

    @Value("${my.constant.LOG_EXCHANGE}")
    private String LOG_EXCHANGE ;
    @Value("${my.constant.LOG_ROUTING_KEY}")
    private String LOG_ROUTING_KEY ;

    private final AmqpTemplate amqpTemplate;

    public LogProducer(@Qualifier("customRabbitTemplate")AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendLog(LogDto log)
    {
        amqpTemplate.convertAndSend(LOG_EXCHANGE, LOG_ROUTING_KEY, log);
    }
}
