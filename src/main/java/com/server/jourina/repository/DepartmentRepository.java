package com.server.jourina.repository;

import com.server.jourina.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);
}