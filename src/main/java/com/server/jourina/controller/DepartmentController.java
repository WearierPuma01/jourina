package com.server.jourina.controller;

import com.server.jourina.bodies.DepartmentBody;
import com.server.jourina.dto.UserDTO;
import com.server.jourina.entity.User;
import com.server.jourina.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    private void addDepartment(@RequestBody DepartmentBody departmentBody, HttpServletResponse response){
        try{
            departmentService.addDepartment(departmentBody.getName());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listUsers")
    public @ResponseBody
    List<UserDTO> userList(@RequestBody DepartmentBody departmentBody){
        List<User> user = departmentService.findByName(departmentBody.getName()).getUser();
        UserDTO userDTO = new UserDTO();
        return userDTO.getUserDTOList(user);
    }
}
