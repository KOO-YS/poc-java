package com.example.plan.controller;

import com.example.plan.dto.MarketplaceAppDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/apps")
public class MarketplaceAppController {


    @PostMapping
    public ResponseEntity<MarketplaceAppDto> createApp() {
        // TODO : 마켓플레이스 앱 생성
        return null;
    }

    @GetMapping
    public ResponseEntity<MarketplaceAppDto> getApps() {
        // TODO : 마켓플레이스 앱 전체 조회
        return null;
    }

    @GetMapping
    public ResponseEntity<MarketplaceAppDto> getApp() {
        // TODO : 마켓플레이스 앱 전체 조회
        return null;
    }

}
