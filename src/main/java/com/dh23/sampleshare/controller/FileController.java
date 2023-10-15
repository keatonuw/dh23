package com.dh23.sampleshare.controller;

import com.dh23.sampleshare.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("/")
@AllArgsConstructor
@Slf4j
public class FileController {

    private final StorageService storage;

    @PostMapping("/upload/")
    public String handleUpload(@RequestParam("title") String title, @RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        log.info("RECEIVED {}", title);
        storage.store(file);
        attributes.addFlashAttribute("message", "Uploaded!");
        return "redirect:/";
    }

    @GetMapping("/play/{id}")
    public String play(@PathVariable("id") long id, Model model) {
        model.addAttribute("url", storage.getMediaUrl(id));
        log.info("Playing {}", storage.getMediaUrl(id));
        return "player";
    }

}
