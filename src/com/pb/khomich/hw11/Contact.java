package com.pb.khomich.hw11;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Contact {

    private final static long serialVersionUID = 42;

    private String FIO; //ФИО
    private transient LocalDate dateOfBirth; //Дата рождения
    public List<String> phone = new ArrayList<>(); //телефоны (количество не ограничено)
    private String adres; //адрес
    private transient LocalDateTime dateOfEditing = LocalDateTime.now(); //время записи редактирования

   /* public Contact() {
    }*/

    public Contact(String FIO, LocalDate dateOfBirth, List<String> phone, String adres) {
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.adres = adres;
        this.dateOfEditing = LocalDateTime.now();

    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
        this.dateOfEditing = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.dateOfEditing = LocalDateTime.now();

    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
        this.dateOfEditing = LocalDateTime.now();

    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
        this.dateOfEditing = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "FIO='" + FIO + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone=" + phone +
                ", adres='" + adres + '\'' +
                ", dateOfEditing=" + dateOfEditing +
                '}';
    }
}
