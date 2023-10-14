package com.dh23.sampleshare.model;

import jakarta.persistence.*;

@Entity
@Table(name="samples", schema = "public")
public class SampleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;
    public String author;
    public String description;
    public String genre;
    public String filename;


}
