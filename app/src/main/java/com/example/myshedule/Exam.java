package com.example.myshedule;


public class Exam {
    private int id;
    private String subject;
    private String date;
    private String time;
    private boolean completed;

    public Exam() {
    }

    public Exam(String subject, String date, String time, boolean completed) {
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

