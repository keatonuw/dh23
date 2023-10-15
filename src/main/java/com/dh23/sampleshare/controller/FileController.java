package com.dh23.sampleshare.controller;

import com.dh23.sampleshare.service.StorageService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class FileController {

    private final StorageService storage;

    @PostMapping("/upload/")
    public void handleUpload(@RequestParam("file")MultipartFile file) {
        storage.store(file);
    }

}