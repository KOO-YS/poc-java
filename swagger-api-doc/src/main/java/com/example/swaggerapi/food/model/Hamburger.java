package com.example.swaggerapi.food.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(title = "햄버거 정보")
public class Hamburger {
    // TODO : model 정보 문서 자동화

    @Schema(title = "햄버거 종류", description = "햄버거 종류", defaultValue = "불고기버거")
    private String name;

    private int price = 6000;
}
