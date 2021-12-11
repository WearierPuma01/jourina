package com.server.jourina.controller;

import com.server.jourina.bodies.AddDepartmentBody;
import com.server.jourina.entity.Department;
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
    private void addDepartment(@RequestBody AddDepartmentBody addDepartmentBody, HttpServletResponse response){
        try{
            departmentService.addDepartment(addDepartmentBody.getName());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listDepartment")
    public @ResponseBody
    List<Department> findAll(){
        return departmentService.findAll();
    }
}
