package com.creditcard.cards.detection.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardsDetectionConfig {

    public static final String CARDS_DETECTION = "CardsDetection";
    public static final String QUEUE_NAME = CARDS_DETECTION + "_queue";
    public static final String Exchange_NAME = CARDS_DETECTION + "_exchange";
    public static final String ROUTING_KEY = CARDS_DETECTION + "_routing";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(Exchange_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
