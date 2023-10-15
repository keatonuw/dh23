package com.dh23.sampleshare.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    List<Vertex> graph;
    List<String> chooseGenre;
    public Graph(){
        this.graph = new ArrayList<>();
        this.chooseGenre = new ArrayList<>();
    }

    public void add(String name){
        if(chooseGenre.contains(name)){
            return;
        }
        Vertex v = new Vertex(name);
        chooseGenre.add(name);
        graph.add(v);
    }

    public void add(String name, String parent){
        if(chooseGenre.contains(name)){
            return;
        }
        if(!chooseGenre.contains(parent)){
            this.add(parent);
        }
        Vertex v = new Vertex(name);
        chooseGenre.add(name);
        graph.add(v);
        for(Vertex genre : graph){
            if(genre.getName().equals(parent)){
                genre.addSubgenre(name);
            }
        }
    }


    public void add(String name, List<String> parents){
        if(chooseGenre.contains(name)){
            return;
        }
        Vertex v = new Vertex(name);
        chooseGenre.add(name);
        graph.add(v);
        for(String parent : parents){
            if(!chooseGenre.contains(parent)){
                this.add(parent);
            }
            for(Vertex genre : graph){
                if(genre.getName().equals(parent)){
                    genre.addSubgenre(name);
                }
            }
        }
    }

    public List<String> getChooseGenre(){
        return chooseGenre;
    }

    public Vertex getVertex(String s){
        for(Vertex v : graph){
            if(v.getName().equals(s)){
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getSize(){
        return chooseGenre.size();
    }

    public List<String> getAllSubgenres(String parent){
        List<String> result = new ArrayList<>();
        result.add(parent);
        if (!chooseGenre.contains(parent)){
            return result;
        }
        HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
        for(Vertex g : graph){
            visited.put(g, false);
        }
        Vertex s = getVertex(parent);
        List<Vertex> queue = new ArrayList<>();
        queue.add(s);
        visited.put(s, true);
        while(!queue.isEmpty()){
            List<Vertex> newLayer = new ArrayList<>();
            for(Vertex v : queue){
                List<String> subgenres = v.getSubgenres();
                for(String n : subgenres){
                    Vertex subgenre = getVertex(n);
                    if(!visited.get(subgenre)){
                        visited.put(subgenre, true);
                        newLayer.add(subgenre);
                        result.add(subgenre.getName());
                    }
                }
            }
            queue = newLayer;
        }
        return result;
    }

    public List<String> getRelated(String parent){
        List<String> result = new ArrayList<>();
        result.add(parent);
        if (!chooseGenre.contains(parent)){
            return result;
        }
        HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
        for(Vertex g : graph){
            visited.put(g, false);
        }
        Vertex s = getVertex(parent);
        visited.put(s, true);
                List<String> subgenres = s.getSubgenres();
                for(String n : subgenres) {
                    Vertex subgenre = getVertex(n);
                    if (!visited.get(subgenre)) {
                        visited.put(subgenre, true);
                        result.add(subgenre.getName());
                    }
                }
        return result;
    }
}