package com.example.test.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.domain.Card;
import com.example.test.domain.CardRepository;
import com.example.test.web.dto.CardSaveDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CardController {

    private final CardRepository cardRepository;

    @PutMapping("/card/{id}")
    public void update(@RequestBody CardSaveDto dto, @PathVariable String id) {
        Card card = dto.toEntity();
        card.set_id(id);

        cardRepository.save(card);
    }

    @DeleteMapping("/card/{id}")
    public int deleteById(@PathVariable String id) {
        cardRepository.deleteById(id);
        return 1;
    }

    @GetMapping("/card")
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @GetMapping("/card/{id}")
    public Card findById(@PathVariable String id) {
        return cardRepository.findById(id).get();
    }

    @PostMapping("/card")
    public Card save(@RequestBody CardSaveDto dto) {
        Card cardEntity = cardRepository.save(dto.toEntity());
        return cardEntity;
    }


}
