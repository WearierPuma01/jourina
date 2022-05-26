package com.server.jourina.repository;

import com.server.jourina.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JournalRepository extends JpaRepository<Journal, Integer> {
    Optional<Journal> findById(Integer id);
    Journal findFirstByOrderByIdDesc();
}