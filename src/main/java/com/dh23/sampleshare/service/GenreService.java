package com.dh23.sampleshare.service;

import com.dh23.sampleshare.model.SampleData;
import com.dh23.sampleshare.repository.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    private Graph graph;  // set me up in CTOR

    @Autowired
    Catalog catalog;

    // CTOR
    public GenreService(){
        Graph g = new Graph();
        g.add("Rock");
        g.add("Metal", "Rock");
        g.add("Shoegaze", "Rock");
        g.add("Alternative Rock", "Rock");
        g.add("Grunge, Alternative Rock");
        g.add("Indie Rock, Rock");
        List<String> noiseParents = new ArrayList<>();
        noiseParents.add("Pop");
        noiseParents.add("Indie Rock");
        g.add("Noise Pop", noiseParents);
        g.add("Heavy Metal", "Metal");
        g.add("Death Metal", "Heavy Metal");
        g.add("Technical Death Metal", "Death Metal");
        g.add("Dissonant Death Metal", "Technical Death Metal");
        g.add("Speed Metal", "Heavy Metal");
        g.add("Power Metal", "Heavy Metal");
        g.add("Thrash Metal", "Metal");
        g.add("Hip Hop");
        g.add("Instrumental Hip Hop", "Hip Hop");
        g.add("Trap", "Hip Hop");
        g.add("Phonk", "Trap");
        g.add("Rare Phonk", "Phonk");
        g.add("Drift Phonk", "Phonk");
        List<String> tmParents = new ArrayList<>();
        tmParents.add("Metal");
        tmParents.add("Trap");
        g.add("Trap Metal", tmParents);
        g.add("Plugg", "Trap");
        g.add("PluggNB", "Plugg");
        g.add("Drill", "Trap");
        g.add("Chicago Drill", "Drill");
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
