package com.server.jourina.dto;

import com.server.jourina.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String name;
    private String login;

    @Transactional
    public List<UserDTO> getUserDTOList(List<User> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList){
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setLogin(user.getLogin());
            userDTOList.add(userDTO);
        }
        return userDTOList;
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
}
