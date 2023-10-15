package com.dh23.sampleshare.service;

import com.dh23.sampleshare.model.SampleData;
import com.dh23.sampleshare.repository.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private Graph graph;  // set me up in CTOR

    @Autowired
    Catalog catalog;

    // CTOR
    public GenreService(){
        Graph g = new Graph();
        g.add("Hardcore");
        g.add("Breakcore", "Hardcore");
        g.add("Mashcore", "Breakcore");
        g.add("Flashcore", "Breakcore");
    }

    // return all sampledata that are of genre or one of it subgenre
    List<SampleData> getAllSamplesOfGenre(String genre) {
        List<String> n = graph.getAllSubgenres(genre);
        return catalog.findSampleByGenre(n);
    }

    List<SampleData> getRelatedGenres(String genre) {
        List<String> n = graph.getRelated(genre);
        return catalog.findSampleByGenre(n);
    }

    List<SampleData> getAllSamples(String genre) {
        return catalog.getSamples();
    }

    List<SampleData> getAllSamplesOfAuthor(String author){
        return catalog.findSampleByArtist(author);
    }
}
