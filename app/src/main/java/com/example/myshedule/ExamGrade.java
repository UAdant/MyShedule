package com.example.myshedule;

public class ExamGrade {
    private int id;
    private String subject;
    private int grade;

    public ExamGrade() {
    }

    public ExamGrade(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
