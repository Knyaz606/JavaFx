package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnect {
    Connection conn = null;

    //Указываем путь к MySql и вход, если путь будит не верный программа продолжить работать без вывода базы данных.
    public static Connection ConnectDb(){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","1234");
            //JOptionPane.showMessageDialog (null, "ConnectionEstablished");
            return conn;
        }catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    //Прописываем путь к нашей таблице и ячейкам.
    public static ObservableList<Workers> getDataUsers() {

        Connection conn = ConnectDb();
        ObservableList<Workers> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM workers.trud");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            list.add(new Workers(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("surname"), rs.getString("patronymic"), rs.getString("date_birth"),rs.getString("post"), rs.getString("telephone"), rs.getString("date_admission"),rs.getString("salary"), rs.getString("department"),rs.getString("nacho")));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
