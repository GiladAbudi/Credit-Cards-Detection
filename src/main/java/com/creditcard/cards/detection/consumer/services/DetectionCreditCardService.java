package com.creditcard.cards.detection.consumer.services;

import com.creditcard.cards.detection.config.CardsDetectionConfig;
import com.creditcard.cards.detection.consumer.repository.CreditCardMessageRepository;
import com.creditcard.cards.detection.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class DetectionCreditCardService {
    @Autowired
    private CreditCardMessageRepository creditCardMessageRepository;
    private final Pattern cardsPattern = Pattern.compile("\\b(?:\\d[ -]*?){13,16}\\b");


    @RabbitListener(queues = CardsDetectionConfig.QUEUE_NAME)
    public void consumeMessageFromQueue(Message message) {
        if (detectCreditCard(message)) {
            creditCardMessageRepository.save(message);
        }
    }

    private boolean detectCreditCard(Message message) {
        return cardsPattern.matcher(message.getBody()).find();
    }
}
