package com.server.jourina.bodies;

public class UpdateNoteBody {
    private Integer id;
    private String incomeDate;
    private String startDate;
    private String endDate;
    private String probeCode;
    private Long probeId;
    private String sample;
    private String element;
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
    private String user;
    private Integer journal;

    public UpdateNoteBody() {
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

    public Long getProbeId() {
        return probeId;
    }

    public void setProbeId(Long probeId) {
        this.probeId = probeId;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getJournal() {
        return journal;
    }

    public void setJournal(Integer journal) {
        this.journal = journal;
    }
}
