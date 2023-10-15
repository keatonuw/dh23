package com.dh23.sampleshare.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Slf4j
public class StorageService {

    Storage storage;
    Bucket bucket;


    // TODO: move to properties and env vars
    String bucketName = "dh23-sample-uploads";
    String projectName = "carbon-pride-402022";
    String creds = "/Users/keatonkowal/Documents/certs/carbon-pride-402022-a6ee1334f217.json";

    public StorageService() throws IOException {
        /*storage = StorageOptions.newBuilder()
                .setProjectId(projectName)
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(creds)))
                .build().getService();
        bucket = storage.get(bucketName);*/
    }

    public void store(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Can't save empty file");
        }
        try {
            byte[] data = file.getBytes();
            Blob blob = bucket.create(file.getName(), data);
            log.info("Stored blob: {}", blob);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return;
    }

}
