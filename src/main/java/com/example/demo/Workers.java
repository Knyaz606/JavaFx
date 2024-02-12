package com.example.demo;

public class Workers {

    int id;
    String name, surname, patronymic, date_birth, post, telephone, date_admission, salary, department, nacho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate_admission() {
        return date_admission;
    }

    public void setDate_admission(String date_admission) {
        this.date_admission = date_admission;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNacho() {
        return nacho;
    }

    public void setNacho(String nacho) {
        this.nacho = nacho;
    }

    public Workers(int id, String name, String surname, String patronymic, String date_birth, String post, String telephone, String date_admission, String salary, String department, String nacho) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date_birth = date_birth;
        this.post = post;
        this.telephone = telephone;
        this.date_admission = date_admission;
        this.salary = salary;
        this.department = department;
        this.nacho = nacho;
    }
}