package com.server.jourina.dto;

import com.server.jourina.entity.Journal;
import com.server.jourina.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLoginDTO {
    private Integer id;
    private String name;
    private String login;
    private RoleDTO role;
    private DepartmentDTO department;
    private List<String> journalName;

    @Transactional
    public UserLoginDTO getUserLoginDTO(User user){
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        department = new DepartmentDTO();
        role = new RoleDTO();

        userLoginDTO.setId(user.getId());
        userLoginDTO.setName(user.getName());
        userLoginDTO.setLogin(user.getLogin());
        role.setName(user.getRole().getName());
        userLoginDTO.setRole(role);
        department.setName(user.getDepartment().getName());
        userLoginDTO.setDepartment(department);
        journalName = new ArrayList<>();
        for(Journal journal : user.getJournal()){
            journalName.add(journal.getName());
        }
        userLoginDTO.setJournalName(journalName);
        return userLoginDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public List<String> getJournalName() {
        return journalName;
    }

    public void setJournalName(List<String> journalName) {
        this.journalName = journalName;
    }
}

