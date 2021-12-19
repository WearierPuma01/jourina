package com.server.jourina.repository;

import com.server.jourina.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SampleRepository extends JpaRepository<Sample, Integer> {
    Sample findByName(String name);
    List<Sample> findAll();
}