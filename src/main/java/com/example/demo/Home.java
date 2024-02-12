package com.example.demo;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private Button About_creators;

    @FXML
    private TextField search;

    @FXML
    private TableColumn<Workers, String> date_admission;

    @FXML
    private TextField date_admission1;

    @FXML
    private TableColumn<Workers, String> date_birth;

    @FXML
    private TextField date_birth1;

    @FXML
    private TableColumn<Workers, String> department;

    @FXML
    private TextField department1;

    @FXML
    private TableColumn<Workers, Integer> id;

    @FXML
    private TextField id1;

    @FXML
    private TableView<Workers> list2;

    @FXML
    private TableColumn<Workers, String> name;

    @FXML
    private TextField name1;

    @FXML
    private TableColumn<Workers, String> patronymic;

    @FXML
    private TextField patronymic1;

    @FXML
    private TableColumn<Workers, String> post;

    @FXML
    private TextField post1;

    @FXML
    private TableColumn<Workers, String> salary;

    @FXML
    private TextField salary1;

    @FXML
    private TableColumn<Workers, String> surname;

    @FXML
    private TextField surname1;

    @FXML
    private TableColumn<Workers, String> telephone;

    @FXML
    private TextField telephone1;

    @FXML
    private TableColumn<Workers, String> nacho;
    @FXML
    private TextField сhief1;


    ObservableList<Workers> listM;
    ObservableList<Workers> dataList;

    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    //Создаем добавление нового рабочего.
    @FXML
    public void Add_user() {
        conn = MysqlConnect.ConnectDb();
        String sql = "insert into workers.trud (id,name,surname,patronymic,date_birth,post,telephone,date_admission,salary,department,nacho) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id1.getText());
            pst.setString(2, name1.getText());
            pst.setString(3, surname1.getText());
            pst.setString(4, patronymic1.getText());
            pst.setString(5, date_birth1.getText());
            pst.setString(6, post1.getText());
            pst.setString(7, telephone1.getText());
            pst.setString(8, date_admission1.getText());
            pst.setString(9, salary1.getText());
            pst.setString(10, department1.getText());
            pst.setString(11, сhief1.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Вы добавели нового сотрудника");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    //Метод показывает выбранного рабочего в окнах.
    @FXML
    public void getSelected(MouseEvent mouseEvent) {
        index = list2.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        } else {
            id1.setText(id.getCellData(index).toString());
            name1.setText(name.getCellData(index).toString());
            surname1.setText(surname.getCellData(index).toString());
            patronymic1.setText(patronymic.getCellData(index).toString());
            date_birth1.setText(date_birth.getCellData(index).toString());
            post1.setText(post.getCellData(index).toString());
            telephone1.setText(telephone.getCellData(index).toString());
            date_admission1.setText(date_admission.getCellData(index).toString());
            salary1.setText(salary.getCellData(index).toString());
            department1.setText(department.getCellData(index).toString());
            сhief1.setText(nacho.getCellData(index).toString());
        }

    }

    public void Edit() {
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = id1.getText();
            String value2 = name1.getText();
            String value3 = surname1.getText();
            String value4 = patronymic1.getText();
            String value5 = date_birth1.getText();
            String value6 = post1.getText();
            String value7 = telephone1.getText();
            String value8 = date_admission1.getText();
            String value9 = salary1.getText();
            String value10 = department1.getText();
            String value11 = сhief1.getText();

            String sql = "update workers.trud set id ='" + value1 + "',name = '" + value2 +
                    "',surname = '" + value3 + "',patronymic = '" + value4 + "',date_birth = '" + value5 +
                    "',post = '" + value6 + "',telephone = '" + value7 + "',date_admission = '" + value8 +
                    "',salary = '" + value9 + "',department = '" + value10 + "',nacho = '" + value11 + "' where id  = '" + value1 + "' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Ваши данные изменены");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void Delete() {
        conn = MysqlConnect.ConnectDb();
        String sql = "delete from workers.trud where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Вы удалили сотрудника");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Указываем что в каких полях должно находится.Поведение наших ячеек.
    public void UpdateTable() {
        id.setCellValueFactory(new PropertyValueFactory<Workers, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Workers, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Workers, String>("surname"));
        patronymic.setCellValueFactory(new PropertyValueFactory<Workers, String>("patronymic"));
        date_birth.setCellValueFactory(new PropertyValueFactory<Workers, String>("date_birth"));
        post.setCellValueFactory(new PropertyValueFactory<Workers, String>("post"));
        telephone.setCellValueFactory(new PropertyValueFactory<Workers, String>("telephone"));
        date_admission.setCellValueFactory(new PropertyValueFactory<Workers, String>("date_admission"));
        salary.setCellValueFactory(new PropertyValueFactory<Workers, String>("salary"));
        department.setCellValueFactory(new PropertyValueFactory<Workers, String>("department"));
        nacho.setCellValueFactory(new PropertyValueFactory<Workers, String>("nacho"));

        listM = MysqlConnect.getDataUsers();
        list2.setItems(listM);
    }

   @FXML
    void search_user() {
        id.setCellValueFactory(new PropertyValueFactory<Workers, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Workers, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Workers, String>("surname"));
        patronymic.setCellValueFactory(new PropertyValueFactory<Workers, String>("patronymic"));
        date_birth.setCellValueFactory(new PropertyValueFactory<Workers, String>("date_birth"));
        post.setCellValueFactory(new PropertyValueFactory<Workers, String>("post"));
        telephone.setCellValueFactory(new PropertyValueFactory<Workers, String>("telephone"));
        date_admission.setCellValueFactory(new PropertyValueFactory<Workers, String>("date_admission"));
        salary.setCellValueFactory(new PropertyValueFactory<Workers, String>("salary"));
        department.setCellValueFactory(new PropertyValueFactory<Workers, String>("department"));
        nacho.setCellValueFactory(new PropertyValueFactory<Workers, String>("nacho"));

        dataList = MysqlConnect.getDataUsers();
        list2.setItems(dataList);

        FilteredList<Workers> filteredData = new FilteredList<>(dataList, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if ( newValue.isEmpty() || newValue.isBlank() || newValue == null ) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getPost().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getDate_admission().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getDepartment().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getDate_birth().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getNacho().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getPatronymic().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getSalary().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (person.getTelephone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<Workers> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(list2.comparatorProperty());
        list2.setItems(sortedData);
    }

    //Метод чтобы обновлялось сразу.
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search_user();
    }

    public void pereh() throws Exception {
        Parent fx = FXMLLoader.load(getClass().getResource("AboutDevelopers.fxml"));
        Stage wind = (Stage) About_creators.getScene().getWindow();
        wind.setScene(new Scene(fx, 1157, 645));

    }

}