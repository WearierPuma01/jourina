package com.server.jourina.service;

import com.server.jourina.entity.User;
import com.server.jourina.repository.DepartmentRepository;
import com.server.jourina.repository.RoleRepository;
import com.server.jourina.repository.UserJournalRepository;
import com.server.jourina.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserJournalRepository userJournalRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String login, String password, String name, String role, String department){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setRole(roleRepository.findByName(role));
        user.setDepartment(departmentRepository.findByName(department));
        userRepository.save(user);
    }

    public void setUserJournal(String login, Integer journalId){
        userJournalRepository.setUserJournal(userRepository.findByLogin(login).getId(), journalId);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
