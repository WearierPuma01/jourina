package com.server.jourina.controller;

import com.server.jourina.bodies.AddUserBody;
import com.server.jourina.bodies.AddUserJournalBody;
import com.server.jourina.bodies.LoginBody;
import com.server.jourina.dto.JournalDTO;
import com.server.jourina.entity.Journal;
import com.server.jourina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    private void addUser(@RequestBody AddUserBody addUserBody, HttpServletResponse response){
        try{
            userService.addUser(addUserBody.getLogin(), addUserBody.getPassword(), addUserBody.getName(), addUserBody.getRole(), addUserBody.getDepartment());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addUserJournal")
    private void addUserJournal(@RequestBody AddUserJournalBody addUserJournalBody, HttpServletResponse response){
        try{
            userService.setUserJournal(addUserJournalBody.getLogin(), addUserJournalBody.getJournal());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userJournals")
    private @ResponseBody List<JournalDTO> userJournals(@RequestBody LoginBody loginBody){
        List<Journal> journal = userService.findByLogin(loginBody.getLogin()).getJournal();
        JournalDTO journalDTO = new JournalDTO();
        return journalDTO.getJournalDTOList(journal);
    }
}
