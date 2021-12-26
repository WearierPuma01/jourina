package com.server.jourina.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.server.jourina.entity.Note;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteDTO {
    private Integer id;
    private String incomeDate;
    private String startDate;
    private String endDate;
    private String probeCode;
    private SampleDTO sampleName;
    private ElementDTO elementName;
    private String document;
    private Double probeWeightF;
    private Double probeWeightS;
    private Double size;
    private Double resultF;
    private Double resultS;
    private Double divergence;
    private Double norma;
    private Double proportion;
    private Double error;
    private String resultDate;
    private UserDTO userName;

    @Transactional
    public List<NoteDTO> getNoteDTOList(List<Note> noteList){
        List<NoteDTO> noteDTOList = new ArrayList<>();
        for(Note note : noteList){
            sampleName = new SampleDTO();
            elementName = new ElementDTO();
            userName = new UserDTO();
            NoteDTO noteDTO = new NoteDTO();
            noteDTO.setId(note.getId());
            noteDTO.setIncomeDate(note.getIncomeDate());
            noteDTO.setStartDate(note.getStartDate());
            noteDTO.setEndDate(note.getEndDate());
            noteDTO.setProbeCode(note.getProbeCode());
            sampleName.setName(note.getSample().getName());
            noteDTO.setSampleName(sampleName);
            elementName.setName(note.getElement().getName());
            noteDTO.setElementName(elementName);
            noteDTO.setDocument(note.getDocument());
            noteDTO.setProbeWeightF(note.getProbeWeightF());
            noteDTO.setProbeWeightS(note.getProbeWeightS());
            noteDTO.setSize(note.getSize());
            noteDTO.setResultF(note.getResultF());
            noteDTO.setResultS(note.getResultS());
            noteDTO.setDivergence(note.getDivergence());
            noteDTO.setNorma(note.getNorma());
            noteDTO.setProportion(note.getProportion());
            noteDTO.setError(note.getError());
            noteDTO.setResultDate(note.getResultDate());
            userName.setName(note.getUsers().getName());
            noteDTOList.add(noteDTO);
        }
        return noteDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProbeCode() {
        return probeCode;
    }

    public void setProbeCode(String probeCode) {
        this.probeCode = probeCode;
    }

    public SampleDTO getSampleName() {
        return sampleName;
    }

    public void setSampleName(SampleDTO sampleName) {
        this.sampleName = sampleName;
    }

    public ElementDTO getElementName() {
        return elementName;
    }

    public void setElementName(ElementDTO elementName) {
        this.elementName = elementName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Double getProbeWeightF() {
        return probeWeightF;
    }

    public void setProbeWeightF(Double probeWeightF) {
        this.probeWeightF = probeWeightF;
    }

    public Double getProbeWeightS() {
        return probeWeightS;
    }

    public void setProbeWeightS(Double probeWeightS) {
        this.probeWeightS = probeWeightS;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getResultF() {
        return resultF;
    }

    public void setResultF(Double resultF) {
        this.resultF = resultF;
    }

    public Double getResultS() {
        return resultS;
    }

    public void setResultS(Double resultS) {
        this.resultS = resultS;
    }

    public Double getDivergence() {
        return divergence;
    }

    public void setDivergence(Double divergence) {
        this.divergence = divergence;
    }

    public Double getNorma() {
        return norma;
    }

    public void setNorma(Double norma) {
        this.norma = norma;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public Double getError() {
        return error;
    }

    public void setError(Double error) {
        this.error = error;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public UserDTO getUserName() {
        return userName;
    }

    public void setUserName(UserDTO userName) {
        this.userName = userName;
    }
}
