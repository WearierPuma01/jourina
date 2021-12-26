package com.server.jourina.controller;

import com.server.jourina.bodies.AddNoteBody;
import com.server.jourina.bodies.UpdateNoteBody;
import com.server.jourina.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/addNote")
    public void addNote(@RequestBody AddNoteBody addNoteBody, HttpServletResponse response){
        try{
            noteService.addNote(addNoteBody.getIncomeDate(), addNoteBody.getStartDate(), addNoteBody.getEndDate(), addNoteBody.getProbeCode(), addNoteBody.getSample(), addNoteBody.getElement(), addNoteBody.getDocument(), addNoteBody.getProbeWeightF(), addNoteBody.getProbeWeightS(), addNoteBody.getSize(), addNoteBody.getResultF(), addNoteBody.getResultS(), addNoteBody.getNorma(), addNoteBody.getResultDate(), addNoteBody.getUser(), addNoteBody.getJournal());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateNote")
    public void updateNote(@RequestBody UpdateNoteBody updateNoteBody, HttpServletResponse response){
        try{
            noteService.updateNote(updateNoteBody.getId(), updateNoteBody.getIncomeDate(), updateNoteBody.getStartDate(), updateNoteBody.getEndDate(), updateNoteBody.getProbeCode(), updateNoteBody.getSample(), updateNoteBody.getElement(), updateNoteBody.getDocument(), updateNoteBody.getProbeWeightF(), updateNoteBody.getProbeWeightS(), updateNoteBody.getSize(), updateNoteBody.getResultF(), updateNoteBody.getResultS(), updateNoteBody.getDivergence(), updateNoteBody.getNorma(), updateNoteBody.getProportion(), updateNoteBody.getError(), updateNoteBody.getResultDate(), updateNoteBody.getUser(), updateNoteBody.getJournal());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
