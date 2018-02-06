package com.ensta.asi34.data;

public class UserInfoDTO {
    private String name;
    private String surname;
    private String mail;

    public UserInfoDTO() {
    }

    public UserInfoDTO(String name, String surname, String mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
