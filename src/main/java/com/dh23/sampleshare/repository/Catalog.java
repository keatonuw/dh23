package com.dh23.sampleshare.repository;

import com.dh23.sampleshare.model.SampleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Sample catalog, e.g. table of all samples + metadata
 */
public interface Catalog extends JpaRepository<SampleData, Long> {

    @Query(value = "SELECT * FROM table", nativeQuery = true)
    List<SampleData> getSamples();
}
