package com.server.jourina.service;

import com.server.jourina.entity.Journal;
import com.server.jourina.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalService {
    @Autowired
    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public void createJournal(String name){
        Journal journal = new Journal();
        journal.setName(name);
        journalRepository.save(journal);
    }

    public Journal findById(Integer id){
        return journalRepository.findById(id).get();
    }
}
