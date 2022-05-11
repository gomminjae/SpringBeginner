package com.example.test.web.dto;

import com.example.test.domain.Card;
import lombok.Data;

@Data
public class CardSaveDto {
    private String name;
    private String phoneNumber;

    public Card toEntity() {
        Card card = new Card();
        card.setName(name);
        card.setPhoneNumber(phoneNumber);

        return card;
    }
}
