package com.ensta.asi34.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Attribute.Type;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.util.Base64;
import java.util.Random;

@Entry(
        base = "ou=people,dc=springframework,dc=org",
        objectClasses = {"person", "inetOrgPerson", "top"})
public class User {

    private static final int GOOGLE_AUTH_SECRET_LENGTH_BYTES = 16;

    @Id
    private Name id;

    @Attribute(name = "uid")
    @DnAttribute(value = "uid", index = 3)
    private String username;

    @Attribute(name = "cn")
    private String name;

    @Attribute(name = "sn")
    private String surname;

    @Attribute(name = "mail")
    private String mail;

    @Attribute(name = "userPassword", type = Type.BINARY)
    @JsonIgnore
    private byte[] password;

    @Attribute(name = "secretQuestion")
    private String question;

    @Attribute(name = "secretResponse")
    private String answer;

    @Attribute(name = "ga")
    private String ga;

    @Attribute(name = "info")
    @JsonIgnore
    private String gAuthSecret;

    public User() {
        generateAuthSecret();
    }

    public Name getId() {
        return id;
    }

    public void setId(Name id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return new String(password);
    }

    public void setPassword(String password) {
        this.password = password.getBytes();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @JsonIgnore
    public String getgAuthSecret() {
        if (gAuthSecret == null)
            generateAuthSecret();
        return gAuthSecret;
    }

    public void setgAuthSecret(String gAuthSecret) {
        this.gAuthSecret = gAuthSecret;
    }

    private void generateAuthSecret() {
        Random r = new Random();
        byte[] secret = new byte[GOOGLE_AUTH_SECRET_LENGTH_BYTES];
        r.nextBytes(secret);
        this.gAuthSecret = Base64.getEncoder().encodeToString(secret);
    }

    public boolean getGa() {
        return Boolean.parseBoolean(ga);
    }

    public void setGa(boolean ga) {
        this.ga = Boolean.toString(ga);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", gAuthSecret='" + gAuthSecret + '\'' +
                ", ga='" + getGa() + '\'' +
                '}';
    }
}