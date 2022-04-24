package com.creditcard.cards.detection.publisher.controllers;

import com.creditcard.cards.detection.dto.Message;
import com.creditcard.cards.detection.publisher.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class CardsDetectionController {

    public static final String MESSAGE = "/message";
    @Autowired
    private CreditCardService creditCardService;


    @PostMapping(MESSAGE)
    public ResponseEntity<Void> detectCardNumber(@RequestBody Message message){
        creditCardService.detectCardNumber(message);
        return ResponseEntity.ok().build();
    }
}
