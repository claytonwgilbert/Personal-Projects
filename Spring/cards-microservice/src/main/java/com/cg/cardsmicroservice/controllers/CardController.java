package com.cg.cardsmicroservice.controllers;

import com.cg.cardsmicroservice.config.CardServiceConfig;
import com.cg.cardsmicroservice.model.Card;
import com.cg.cardsmicroservice.model.Customer;
import com.cg.cardsmicroservice.model.Properties;
import com.cg.cardsmicroservice.repository.CardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    private CardRepository cardsRepository;
    private CardServiceConfig cardServiceConfig;

    public CardController(CardRepository cardsRepository, CardServiceConfig cardServiceConfig) {
        this.cardsRepository = cardsRepository;
        this.cardServiceConfig = cardServiceConfig;
    }

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        List<Card> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }

    //Retrieving config properties from config server
    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardServiceConfig.getMsg(), cardServiceConfig.getBuildVersion(),
                cardServiceConfig.getMailDetails(), cardServiceConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
