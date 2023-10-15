package com.dh23.sampleshare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    public String tag;

    public List<String> getTags() {
        return List.of(tag, genre);
    }

}
