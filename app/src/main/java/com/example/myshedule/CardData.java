package com.example.myshedule;

import java.util.List;

public class CardData {
    private String date;
    private List<String> tasks;
    private String subject;
    private String type;

    public CardData(String date, List<String> tasks, String subject, String type) {
        this.date = date;
        this.tasks = tasks;
        this.subject = subject;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getSubject() {
        return subject;
    }

    public String getType() {
        return type;
    }
}
