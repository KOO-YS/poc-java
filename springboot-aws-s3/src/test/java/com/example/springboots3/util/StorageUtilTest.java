package com.example.springboots3.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
public class StorageUtilTest {

    @Autowired
    AmazonS3StorageUtil storageUtil;

    @Test
    void create() {
        storageUtil.createBucket("hello");
    }

    @Test
    void upload() {
        storageUtil.uploadObject("yaans-bucket");
    }
}
