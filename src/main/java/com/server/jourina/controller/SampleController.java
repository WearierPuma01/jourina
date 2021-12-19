package com.server.jourina.controller;

import com.server.jourina.bodies.NameBody;
import com.server.jourina.entity.Sample;
import com.server.jourina.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @PostMapping("/addSample")
    public void addSample(@RequestBody NameBody nameBody, HttpServletResponse response){
        try{
            sampleService.addSample(nameBody.getName());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listSample")
    public @ResponseBody
    List<Sample> findAll(){
        return sampleService.findAll();
    }
}
