package com.server.jourina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourinaGUI extends JFrame {
    private JLabel authorizationLabel = new JLabel("Authorization");
    private JLabel loginLabel = new JLabel("Login:");
    private JTextField loginTextField = new JTextField();
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField passwordTextField = new JTextField();
    private JButton authorizationButton = new JButton("Go in!");

    public JourinaGUI (){
        super("Jourina");
        this.setBounds(100, 100, 400, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container containerAu = this.getContentPane();
        containerAu.setLayout(new GridLayout(6,1,5,5));
        authorizationButton.addActionListener(new AuthorizationButtonEventListener ());
        containerAu.add(authorizationLabel);
        containerAu.add(loginLabel);
        containerAu.add(loginTextField);
        containerAu.add(passwordLabel);
        containerAu.add(passwordTextField);
        containerAu.add(authorizationButton);
    }

    class AuthorizationButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {

        }
    }
}
