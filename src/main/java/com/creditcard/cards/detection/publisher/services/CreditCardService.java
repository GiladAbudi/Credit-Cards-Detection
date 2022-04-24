package com.creditcard.cards.detection.publisher.services;

import com.creditcard.cards.detection.config.CardsDetectionConfig;
import com.creditcard.cards.detection.dto.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void detectCardNumber(Message message) {
        rabbitTemplate.convertAndSend(CardsDetectionConfig.Exchange_NAME, CardsDetectionConfig.ROUTING_KEY, message);
    }


}
