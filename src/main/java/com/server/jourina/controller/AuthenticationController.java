package com.server.jourina.controller;

import com.server.jourina.bodies.AuthRequest;
import com.server.jourina.dto.UserDTO;
import com.server.jourina.entity.User;
import com.server.jourina.entity.UserAuth;
import com.server.jourina.repository.UserRepository;
import com.server.jourina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping ("/login")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody UserAuth login(@RequestBody AuthRequest authRequest){
        List<User> users = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        Authentication authentication;
        try{
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
            System.out.println(authentication);
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login or Password wrong!", e);
        }

        UserAuth userAuth = new UserAuth();
        userAuth.user = userService.findByLogin(authRequest.getLogin());
        if(userAuth.user.getPassword().equals(authRequest.getPassword())) {
            userAuth.successAuth();
            users.add(userAuth.user);

        }
        else
            userAuth.unsucessAuth();

        return userAuth;
    }
}
