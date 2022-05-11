package com.example.test.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "card")
public class Card {

    @Id
    private String _id;
    private String name;
    private String phoneNumber;

}
