package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class About {

    @FXML
    private Button bak;

    @FXML
    void initialize() {

    }

    public void pereh()throws Exception {
        Parent fx = FXMLLoader.load(getClass().getResource("app.fxml"));
        Stage wind = (Stage) bak.getScene().getWindow();
        wind.setScene(new Scene(fx, 1157, 645));

    }

}