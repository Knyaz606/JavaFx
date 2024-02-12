package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Registr {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox Femaleg;

    @FXML
    private CheckBox Maleg;

    @FXML
    private Button Register2;

    @FXML
    private Button back;

    @FXML
    private TextField loginFild;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpUser;

    @FXML
    void initialize() {

        Register2.setOnAction(event -> {
            RegNewPolzovatel();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/demo/hello-view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }

   public void pereh() throws Exception {
        Parent fx = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage wind = (Stage) back.getScene().getWindow();
        wind.setScene(new Scene(fx, 700, 345));

    }

    private void RegNewPolzovatel() {

        Database1 data = new Database1();

        String firstName = signUpUser.getText();
        String lastName = signUpLastName.getText();
        String userName = loginFild.getText();
        String password = passwordfield.getText();
        String gender = "";
        if (Maleg.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName, lastName, userName, password, gender);

        data.RegPolzovatel(user);
    }

}