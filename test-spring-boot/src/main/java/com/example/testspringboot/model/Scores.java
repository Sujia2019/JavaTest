package com.example.testspringboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("scores")
public class Scores {
    private int English;
    private int Math;
    private int Computer;
}
