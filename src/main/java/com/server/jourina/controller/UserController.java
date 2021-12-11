package com.server.jourina.controller;

import com.server.jourina.bodies.AddUserBody;
import com.server.jourina.entity.User;
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

    @PostMapping("/listUser")
    public @ResponseBody List<User> findAll(){
        return userService.findALl();
    }
}
