package com.server.jourina.service;

import com.server.jourina.entity.Department;
import com.server.jourina.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void addDepartment(String name){
        Department department = new Department();
        department.setName(name);
        departmentRepository.save(department);
    }

    public Department findByName(String name){
        return departmentRepository.findByName(name);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
}
