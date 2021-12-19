package com.server.jourina.controller;

import com.server.jourina.bodies.CreateJournalBody;
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
import java.util.List;

@Controller
public class JournalController {
    @Autowired
    private JournalService journalService;

    @PostMapping("/createJournal")
    public void createJournal(@RequestBody CreateJournalBody createJournalBody, HttpServletResponse response){
        try{
            journalService.createJournal(createJournalBody.getName());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listNote")
    public @ResponseBody
    List<NoteDTO> listNote(@RequestBody JournalBody journalBody){
        List<Note> note = journalService.findById(journalBody.getJournal()).getNote();
        NoteDTO noteDTO = new NoteDTO();
        return noteDTO.getNoteDTOList(note);
    }

}
