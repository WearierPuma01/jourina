package com.server.jourina.dto;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ElementDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
