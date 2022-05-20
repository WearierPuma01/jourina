package com.server.jourina.controller;

import com.server.jourina.bodies.AuthRequest;
import com.server.jourina.entity.User;
import com.server.jourina.entity.UserAuth;
import com.server.jourina.repository.UserRepository;
import com.server.jourina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody UserAuth login(@RequestBody AuthRequest authRequest){


        UserAuth userAuth = new UserAuth();
        userAuth.user = userService.findByLogin(authRequest.getLogin());
        if(userAuth.user.getPassword().equals(authRequest.getPassword()))
            userAuth.successAuth();
        else
            userAuth.unsucessAuth();
        return userAuth;
    }
}
