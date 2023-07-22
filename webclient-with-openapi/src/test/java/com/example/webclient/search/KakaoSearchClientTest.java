package com.example.webclient.search;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KakaoSearchClientTest {

    @Autowired
    KakaoSearchClient searchClient;

    @Test
    void search() {
        String response = searchClient.printSearch("water");
        System.out.println(response);
    }

}
