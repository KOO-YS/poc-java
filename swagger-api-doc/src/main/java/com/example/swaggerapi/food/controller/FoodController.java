package com.example.swaggerapi.food.controller;

import com.example.swaggerapi.food.model.Food;
import com.example.swaggerapi.food.model.Hamburger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@Tag(name = "FoodController", description = "음식 컨트롤러")
@Slf4j
@RequestMapping("/v1/api/food")
@RestController
public class FoodController {



    @Operation(operationId = "getFoodInfo", summary = "음식 정보 조회", description = "해당 이름을 가진 음식 정보를 조회한다. 현재는 햄버거만 조회 가능")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = Food.class))),
        @ApiResponse(responseCode = "204", description = "No Content")
    })
    @GetMapping("/{foodName}")
    public ResponseEntity getFoodInfo(@PathVariable("foodName") String foodName) {
        log.info("[getFoodInfo] : {}", foodName);
        if (foodName.equals("hamburger"))
            return ResponseEntity.ok(Hamburger.builder().build());
        return ResponseEntity.noContent().build();
    }
}
