package com.server.jourina.service;

import com.server.jourina.entity.Log;
import com.server.jourina.repository.JournalRepository;
import com.server.jourina.repository.LogRepository;
import com.server.jourina.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogService {
    @Autowired
    private final LogRepository logRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JournalRepository journalRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void addLog(Date time, String login, Integer journalId, String coordinate, String oldValue, String newValue){
        Log log = new Log();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        log.setTime(df.format(time));
        log.setUser(userRepository.findByLogin(login));
        log.setJournal(journalRepository.findById(journalId).get());
        log.setCoordinate(coordinate);
        log.setOldValue(oldValue);
        log.setNewValue(newValue);
        logRepository.save(log);

    }
}
