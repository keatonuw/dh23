package com.dh23.sampleshare.repository;

import com.dh23.sampleshare.model.SampleData;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Sample catalog, e.g. table of all samples + metadata
 */
public interface Catalog extends JpaRepository<SampleData, Long> {

    @Query(value = "SELECT * FROM samples", nativeQuery = true)
    List<SampleData> getSamples();

    @Query(value = "SELECT * FROM samples WHERE genre in :genres", nativeQuery = true)
    List<SampleData> findSampleByGenre(@Param("genres") List<String> genres);

    @Query(value = "SELECT * FROM samples WHERE tag = :tag", nativeQuery = true)
    List<SampleData> findSampleByTag(@Param("tag") String tag);

    @Query(value = "SELECT * FROM samples WHERE author = :author", nativeQuery = true)
    List<SampleData> findSampleByArtist(@Param("author") String author);
}
