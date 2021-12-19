package com.server.jourina.service;

import com.server.jourina.entity.Element;
import com.server.jourina.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {
    @Autowired
    private final ElementRepository elementRepository;

    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void addElement (String name){
        Element element = new Element();
        element.setName(name);
        elementRepository.save(element);
    }

    public Element findElement(String name){
        return elementRepository.findByName(name);
    }

    public List<Element> findAll(){
        return elementRepository.findAll();
    }
}
