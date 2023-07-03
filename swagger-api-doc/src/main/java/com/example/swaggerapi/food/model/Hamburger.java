package com.example.swaggerapi.food.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class Hamburger {


    private String name = "불고기버거";

    private int price = 6000;
}
