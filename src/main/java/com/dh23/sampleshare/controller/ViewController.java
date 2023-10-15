package com.dh23.sampleshare.controller;

import com.dh23.sampleshare.model.SampleData;
import com.dh23.sampleshare.service.GenreService;
import com.dh23.sampleshare.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * handles the web template
 */
@Controller
@AllArgsConstructor
@Slf4j
public class ViewController {

    StorageService storage;
    GenreService genres;

    @GetMapping("/upload/")
    public String presentUploadForm(Model model) {
        return "upload";
    }

    @GetMapping("/feed/{page}")
    public String feed(@PathVariable("page") int page, Model model) {
        model.addAttribute("samples", storage.getAll());  // TODO: replace with Aaron's service
        return "feedpage";
    }

    @GetMapping("/feed/filter/{root}")
    public String feed(@PathVariable("root") String root, Model model) {
        List<SampleData> samples = genres.getRelatedGenres(root);
        log.info("GOT {}", samples);
        model.addAttribute("samples", samples);
        return "feedpage";
    }

    @GetMapping("/genres/{root}")
    public String genres(@PathVariable("root") String root, Model model) {
        if (root.equals("root")) {
            model.addAttribute("genres", genres.getRootGenres());
        } else {
            model.addAttribute("genres", genres.getRelated(root));
            model.addAttribute("root", root);
        }
        return "genres";
    }

}
