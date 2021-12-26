package com.server.jourina.service;

import com.server.jourina.entity.Note;
import com.server.jourina.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private final NoteRepository noteRepository;
    @Autowired
    private SampleRepository sampleRepository;
    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JournalRepository journalRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNote(String incomeDate, String startDate, String endDate, String probeCode, String sample, String element, String document,
                        Double probeWeightF, Double probeWeightS, Double size, Double resultF,
                        Double resultS, Double norma, String resultDate, String user, Integer journal){
        Note note = new Note();
        note.setIncomeDate(incomeDate);
        note.setStartDate(startDate);
        note.setEndDate(endDate);
        note.setProbeCode(probeCode);
        note.setSample(sampleRepository.findByName(sample));
        note.setElement(elementRepository.findByName(element));
        note.setDocument(document);
        note.setProbeWeightF(probeWeightF);
        note.setProbeWeightS(probeWeightS);
        note.setSize(size);
        note.setResultF(resultF);
        note.setResultS(resultS);
        Double mx = (resultF + resultS)/2;
        note.setDivergence((Math.abs(resultF-resultS)/mx)*100);
        note.setNorma(norma);
        note.setProportion(mx);
        note.setError(0.01*mx*35);
        note.setResultDate(resultDate);
        note.setUsers(userRepository.findByLogin(user));
        note.setJournal(journalRepository.findById(journal).get());
        noteRepository.save(note);
    }

    public void updateNote(Integer id, String incomeDate, String startDate, String endDate, String probeCode, String sample, String element, String document,
                           Double probeWeightF, Double probeWeightS, Double size, Double resultF,
                           Double resultS, Double divergence, Double norma, Double proportion,
                           Double error, String resultDate, String user, Integer journal){
        Note note = noteRepository.findById(id).get();
        note.setIncomeDate(incomeDate);
        note.setStartDate(startDate);
        note.setEndDate(endDate);
        note.setProbeCode(probeCode);
        note.setSample(sampleRepository.findByName(sample));
        note.setElement(elementRepository.findByName(element));
        note.setDocument(document);
        note.setProbeWeightF(probeWeightF);
        note.setProbeWeightS(probeWeightS);
        note.setSize(size);
        note.setResultF(resultF);
        note.setResultS(resultS);
        note.setDivergence(divergence);
        note.setNorma(norma);
        note.setProportion(proportion);
        note.setError(error);
        note.setResultDate(resultDate);
        note.setUsers(userRepository.findByLogin(user));
        note.setJournal(journalRepository.findById(journal).get());
        noteRepository.save(note);
    }
}
