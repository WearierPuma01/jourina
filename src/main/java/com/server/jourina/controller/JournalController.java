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
    public @ResponseBody Integer createJournal(@RequestBody CreateJournalBody createJournalBody){
        journalService.createJournal(createJournalBody.getName());
        return journalService.getLastJournal().getId();
    }

    @PostMapping("/listNote")
    public @ResponseBody
    List<NoteDTO> listNote(@RequestBody JournalBody journalBody){
        List<Note> note = journalService.findById(journalBody.getJournal()).getNote();
        NoteDTO noteDTO = new NoteDTO();
        return noteDTO.getNoteDTOList(note);
    }

}
