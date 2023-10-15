package com.dh23.sampleshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * handles the web template
 */
@Controller
public class ViewController {

    @GetMapping("/upload-form/")
    public String presentUploadForm(Model model) {
        return "upload";
    }

}
