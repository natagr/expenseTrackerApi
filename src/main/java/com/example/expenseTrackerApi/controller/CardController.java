package com.example.expenseTrackerApi.controller;

import com.example.expenseTrackerApi.model.Card;
import com.example.expenseTrackerApi.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Card> getCardDetails(@RequestParam Integer id) {
        List<Card> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }

}