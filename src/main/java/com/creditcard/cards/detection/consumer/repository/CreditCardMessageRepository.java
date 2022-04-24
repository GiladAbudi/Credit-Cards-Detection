package com.creditcard.cards.detection.consumer.repository;

import com.creditcard.cards.detection.dto.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardMessageRepository extends MongoRepository<Message,String> {
}
