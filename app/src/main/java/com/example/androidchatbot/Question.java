package com.example.androidchatbot;

public class Question {

    private String question;
    private String options;
    private String[] choices;

    Question(String question, String options, String[] choices) {
        this.question = question;
        this.options = options;
        this.choices = choices;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }
}
