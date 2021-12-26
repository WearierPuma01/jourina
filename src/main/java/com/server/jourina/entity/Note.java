package com.server.jourina.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "income_date", nullable = false)
    private String incomeDate;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date", nullable = false)
    private String endDate;

    @Column(name = "probe_code", nullable = false)
    private String probeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sample", referencedColumnName = "id")
    private Sample sample;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "element", referencedColumnName = "id")
    private Element element;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "probe_weight_f", nullable = false)
    private Double probeWeightF;

    @Column(name = "probe_weight_s", nullable = false)
    private Double probeWeightS;

    @Column(name = "size", nullable = false)
    private Double size;

    @Column(name = "result_f", nullable = false)
    private Double resultF;

    @Column(name = "result_s", nullable = false)
    private Double resultS;

    @Column(name = "divergence", nullable = false)
    private Double divergence;

    @Column(name = "norma", nullable = false)
    private Double norma;

    @Column(name = "proportion", nullable = false)
    private Double proportion;

    @Column(name = "error", nullable = false)
    private Double error;

    @Column(name = "result_date", nullable = false)
    private String resultDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "journal_id", nullable = false)
    private Journal journal;

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public Double getError() {
        return error;
    }

    public void setError(Double error) {
        this.error = error;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public Double getNorma() {
        return norma;
    }

    public void setNorma(Double norma) {
        this.norma = norma;
    }

    public Double getDivergence() {
        return divergence;
    }

    public void setDivergence(Double divergence) {
        this.divergence = divergence;
    }

    public Double getResultS() {
        return resultS;
    }

    public void setResultS(Double resultS) {
        this.resultS = resultS;
    }

    public Double getResultF() {
        return resultF;
    }

    public void setResultF(Double resultF) {
        this.resultF = resultF;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getProbeWeightS() {
        return probeWeightS;
    }

    public void setProbeWeightS(Double probeWeightS) {
        this.probeWeightS = probeWeightS;
    }

    public Double getProbeWeightF() {
        return probeWeightF;
    }

    public void setProbeWeightF(Double probeWeightF) {
        this.probeWeightF = probeWeightF;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getProbeCode() {
        return probeCode;
    }

    public void setProbeCode(String probeCode) {
        this.probeCode = probeCode;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(incomeDate, note.incomeDate) && Objects.equals(startDate, note.startDate) && Objects.equals(endDate, note.endDate) && Objects.equals(probeCode, note.probeCode) && Objects.equals(sample, note.sample) && Objects.equals(element, note.element) && Objects.equals(document, note.document) && Objects.equals(probeWeightF, note.probeWeightF) && Objects.equals(probeWeightS, note.probeWeightS) && Objects.equals(size, note.size) && Objects.equals(resultF, note.resultF) && Objects.equals(resultS, note.resultS) && Objects.equals(divergence, note.divergence) && Objects.equals(norma, note.norma) && Objects.equals(proportion, note.proportion) && Objects.equals(error, note.error) && Objects.equals(resultDate, note.resultDate) && Objects.equals(users, note.users) && Objects.equals(journal, note.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incomeDate, startDate, endDate, probeCode, sample, element, document, probeWeightF, probeWeightS, size, resultF, resultS, divergence, norma, proportion, error, resultDate, users, journal);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", incomeDate='" + incomeDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", probeCode='" + probeCode + '\'' +
                ", sample=" + sample +
                ", element=" + element +
                ", document='" + document + '\'' +
                ", probeWeightF=" + probeWeightF +
                ", probeWeightS=" + probeWeightS +
                ", size=" + size +
                ", resultF=" + resultF +
                ", resultS=" + resultS +
                ", divergence=" + divergence +
                ", norma=" + norma +
                ", proportion=" + proportion +
                ", error=" + error +
                ", resultDate='" + resultDate + '\'' +
                ", users=" + users +
                ", journal=" + journal +
                '}';
    }

    public Note() {
    }
}