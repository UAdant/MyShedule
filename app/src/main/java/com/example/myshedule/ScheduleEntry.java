package com.example.myshedule;

public class ScheduleEntry {
    private int id;
    private String subject;
    private String type;
    private String date;
    private boolean completed;

    public ScheduleEntry() {
    }

    public ScheduleEntry(String subject, String type, String date, boolean completed) {
        this.subject = subject;
        this.type = type;
        this.date = date;
        this.completed = completed;
    }

    // Getters and setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
