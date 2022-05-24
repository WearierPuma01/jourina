package com.server.jourina.service;

import com.server.jourina.entity.User;
import com.server.jourina.repository.DepartmentRepository;
import com.server.jourina.repository.RoleRepository;
import com.server.jourina.repository.UserJournalRepository;
import com.server.jourina.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = findByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
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
