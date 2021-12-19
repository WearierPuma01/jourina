package com.server.jourina.service;

import com.server.jourina.entity.Sample;
import com.server.jourina.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {
    @Autowired
    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public void addSample(String name){
        Sample sample = new Sample();
        sample.setName(name);
        sampleRepository.save(sample);
    }

    public Sample findSample(String name){
        return sampleRepository.findByName(name);
    }

    public List<Sample> findAll(){
        return sampleRepository.findAll();
    }
}
