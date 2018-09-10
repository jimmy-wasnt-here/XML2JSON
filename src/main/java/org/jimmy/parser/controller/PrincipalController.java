package org.jimmy.parser.controller;

import org.apache.commons.io.FileUtils;
import org.jimmy.parser.view.Principal;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class PrincipalController {
    private Logger log = LoggerFactory.getLogger("parseLogger");
    private Principal principalScreen;

    public PrincipalController() {
        log.info("Initializing program.");
        principalScreen = new Principal(this);
        principalScreen.setVisible(true);
    }


    private static String parseXMLToJSONString(String xml) {
        JSONObject json;
        try {
            json = XML.toJSONObject(xmlExample);
            return json.toString();
        } catch (Exception e) {
            json = new JSONObject();
            return json.put("Error", "Error en la creacion del json").toString();
        }
    }


    public void performConversion(String xmlToParse) {
        String jsonToShow = parseXMLToJSONString(xmlToParse);
        principalScreen.getOutputTextArea().setText(jsonToShow);

    }

    public void performExport() {

    }

    public void performExit() {
        System.exit(0);
    }

    private static String xmlExample = "<note>\n" +
            "<to>Tove</to>\n" +
            "<from>Jani</from>\n" +
            "<heading>Reminder</heading>\n" +
            "<body>Don't forget me this weekend!</body>\n" +
            "</note>";

    public void performLoadingFile() {
        JFileChooser jsonFileChooser = new JFileChooser();
        jsonFileChooser.showOpenDialog(null);
        try {
            File jsonFile = jsonFileChooser.getSelectedFile();

            if (jsonFile != null) {
                String json = FileUtils.readFileToString(jsonFile);
                principalScreen.getInputTextArea().setText(json);
                String filePath = jsonFile.getAbsolutePath();
            }
        } catch (IOException ioException) {
            log.error("Error en la lectura del fichero.");
        }

    }
}
