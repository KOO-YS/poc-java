package com.example.springboots3.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * https://catalog.workshops.aws/general-immersionday/ko-KR/basic-modules/60-s3/s3
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AmazonS3StorageUtil implements StorageUtil{

    private final AmazonS3 amazonS3;


    @Override
    public void createBucket(String bucketName) {

        if (amazonS3.doesBucketExistV2(bucketName)) {
            log.warn("bucket {} already existes", bucketName);

        } else {
            Bucket bucket = amazonS3.createBucket(bucketName);
            log.info("bucket {} is created", bucket);
        }

    }

    @Override
    public List<Bucket> listBuckets() {
        return null;
    }

    @Override
    public void uploadObject(String bucketName) {
        // Upload a text string as a new object.
        amazonS3.putObject(bucketName, "stringObjKeyName", "Uploaded String Object");

        // Upload a file as a new object with ContentType and title specified.
        PutObjectRequest request = new PutObjectRequest(bucketName, "fileObjKeyName", new File("testFile"));
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("plain/text");
        metadata.addUserMetadata("title", "someTitle");
        request.setMetadata(metadata);
    }

    @Override
    public void uploadMultiObject() {

    }

    @Override
    public void uploadDirectory() {

    }

    @Override
    public void downloadObject() {

    }

    @Override
    public void downloadDirectory() {

    }

    @Override
    public void deleteObject() {

    }

    @Override
    public void deleteAllObject() {

    }

    @Override
    public void deleteBucket() {

    }
}
