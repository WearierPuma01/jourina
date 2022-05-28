package com.server.jourina.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.server.jourina.bodies.CreateJournalBody;
import com.server.jourina.bodies.DeleteBody;
import com.server.jourina.bodies.JournalBody;
import com.server.jourina.dto.NoteDTO;
import com.server.jourina.entity.Note;
import com.server.jourina.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JournalController {
    @Autowired
    private JournalService journalService;

    @PostMapping("/createJournal")
    public @ResponseBody Map createJournal(@RequestBody CreateJournalBody createJournalBody){
        journalService.createJournal(createJournalBody.getName());
        Map<String, Integer> map = new HashMap<>();
        map.put("id", journalService.getLastJournal().getId());
        return map;
    }

    @PostMapping("/listNote")
    public @ResponseBody
    List<NoteDTO> listNote(@RequestBody JournalBody journalBody){
        List<Note> note = journalService.findById(journalBody.getJournal()).getNote();
        NoteDTO noteDTO = new NoteDTO();
        return noteDTO.getNoteDTOList(note);
    }

    @PostMapping("/deleteJournal")
    public void deleteJournal(@RequestBody DeleteBody deleteBody, HttpServletResponse response){
        try{
            journalService.deleteJournal(deleteBody.getId());
            response.setStatus(HttpServletResponse.SC_OK);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
