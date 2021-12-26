package com.server.jourina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.swing.*;

@SpringBootApplication
public class JourinaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JourinaApplication.class, args);
        JourinaGUI jourinaGUI = new JourinaGUI();
        jourinaGUI.setVisible(true);

    }

}
