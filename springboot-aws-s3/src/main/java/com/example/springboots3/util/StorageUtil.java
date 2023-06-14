package com.example.springboots3.util;

import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

/**
 *  Reference
 *      - https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/java/example_code/s3/src/main/java/aws/example/s3
 *      - https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code/s3
 */
public interface StorageUtil {

    void createBucket(String bucketName);

    List<Bucket> listBuckets();

    void uploadObject();

    void uploadMultiObject();

    void uploadDirectory();

    void downloadObject();

    void downloadDirectory();

    // must delete all object, BEFORE delete bucket
    void deleteObject();

    // must delete all object, BEFORE delete bucket
    void deleteAllObject();

    void deleteBucket();
}
