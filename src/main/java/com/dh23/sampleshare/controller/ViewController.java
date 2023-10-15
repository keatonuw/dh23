package com.dh23.sampleshare.controller;

import com.dh23.sampleshare.model.SampleData;
import com.dh23.sampleshare.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

/**
 * handles the web template
 */
@Controller
@AllArgsConstructor
public class ViewController {

    StorageService storage;

    @GetMapping("/upload/")
    public String presentUploadForm(Model model) {
        return "upload";
    }

    @GetMapping("/feed/{page}")
    public String feed(@PathVariable("page") int page, Model model) {
        model.addAttribute("samples", storage.getAll());  // TODO: replace with Aaron's service
        return "feedpage";
    }

}
