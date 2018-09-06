package org.jimmy.parser.view;

import org.jimmy.parser.controller.PrincipalController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Principal extends JFrame {
    private JButton loadFileButton;
    private JButton convertFileButton;
    private JButton exportFileButton;
    private JTextArea xmlTextArea;
    private JTextArea jsonTextArea;
    private JButton exitProgramButton;
    private JPanel mainPanel;

    private PrincipalController controller;

    public Principal(PrincipalController controller) {
        super();
        initComponents();
        this.controller = controller;
    }

    private void initComponents() {
        this.setContentPane(mainPanel);
        this.pack();
        this.setMinimumSize(new Dimension(500, 600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loadFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.performLoadingFile();
            }
        });
        convertFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.performConversion(xmlTextArea.getText());
            }
        });
        exportFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.performExport();
            }
        });
        exitProgramButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.performExit();
            }
        });

        this.setVisible(true);
    }


    public void setData(Principal data) {
    }

    public void getData(Principal data) {
    }

    public boolean isModified(Principal data) {
        return false;
    }

    public JTextArea getOutputTextArea() {
        return jsonTextArea;
    }

    public JTextArea getInputTextArea() {
        return xmlTextArea;
    }

}
