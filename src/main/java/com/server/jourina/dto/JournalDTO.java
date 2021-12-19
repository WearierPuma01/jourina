package com.server.jourina.dto;

import com.server.jourina.entity.Journal;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class JournalDTO {
    private String name;

    @Transactional
    public List<JournalDTO> getJournalDTOList(List<Journal> journalList){
        List<JournalDTO> journalDTOList = new ArrayList<>();
        for(Journal journal : journalList){
            JournalDTO journalDTO = new JournalDTO();
            journalDTO.setName(journal.getName());
            journalDTOList.add(journalDTO);
        }
        return journalDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
