package com.ensta.asi34.data;

public class UserPassDTO {
    private String password;
    private String question;
    private String answer;

    public UserPassDTO() {
    }

    public UserPassDTO(String password, String question, String answer) {
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}


