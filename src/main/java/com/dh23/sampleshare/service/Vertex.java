package com.dh23.sampleshare.service;

import java.util.*;
public class Vertex {
    private String name;
    private List<String> subgenres;
    public Vertex(String name){
        this.name = name;
        this.subgenres = new ArrayList<String>();
    }
    public void addSubgenre(String subgenre){
        subgenres.add(subgenre);
    }

    public String getName(){
        return name;
    }

    public List<String> getSubgenres(){
        return subgenres;
    }
}