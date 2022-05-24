package com.server.jourina.controller;

import com.server.jourina.bodies.AuthRequest;
import com.server.jourina.service.UserService;
import com.server.jourina.dto.UserLoginDTO;
import com.server.jourina.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody AuthRequest authRequest){
        Authentication authentication;
        try{
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
            System.out.println(authentication);
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login or Password wrong!", e);
        }
    }

    @PostMapping("/userInfo")
    private @ResponseBody UserLoginDTO userLoginDTO(@RequestBody AuthRequest authRequest){
        User user = userService.findByLogin(authRequest.getLogin());
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        return userLoginDTO.getUserLoginDTO(user);
    }
}
