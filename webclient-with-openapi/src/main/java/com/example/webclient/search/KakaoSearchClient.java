package com.example.webclient.search;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpHeaders;

@Component
public class KakaoSearchClient {

    private final String URL = "https://dapi.kakao.com/v2";

    @Value("${openapi.kakao.search.rest-api-key}")
    private String REST_API_KEY;

    /**
     * TODO : api 호출
     * @param keyword 검색 키워드
     */
    public String printSearch(String keyword) {
        System.out.println("REST_API_KEY : "+REST_API_KEY);
        String authorizationValue = "KakaoAK " + REST_API_KEY;
        // + Map 형태로 나와야할 듯 하다

        System.out.println("authorizationValue : "+ authorizationValue);

        WebClient kakaoClient = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("Authorization", authorizationValue)
            .build();

        return kakaoClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/blog")
                        .queryParam("query", keyword)           // String : not null
                        .queryParam("sort", "recency")      // String : nullable
                        .queryParam("page", "1")                // Integer : nullable
                        .queryParam("size", "1")            // Integer : nullable
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    /**
     * TODO : api 응답용 객체 작성
     */
    public <T> T responseSearch(String keyword) {
        System.out.println("REST_API_KEY : "+REST_API_KEY);
        String authorizationValue = "KakaoAK " + REST_API_KEY;
        // + Map 형태로 나와야할 듯 하다

        System.out.println("authorizationValue : "+ authorizationValue);

        WebClient kakaoClient = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("Authorization", authorizationValue)
                .build();

        return (T)kakaoClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/blog")
                        .queryParam("query", keyword)           // String : not null
                        .queryParam("sort", "recency")      // String : nullable
                        .queryParam("page", "1")                // Integer : nullable
                        .queryParam("size", "1")            // Integer : nullable
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
