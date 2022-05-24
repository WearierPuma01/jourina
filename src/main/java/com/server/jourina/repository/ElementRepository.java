package com.server.jourina.repository;

import com.server.jourina.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementRepository extends JpaRepository<Element, Integer> {
    Element findByName(String name);
    List<Element> findAll();
}