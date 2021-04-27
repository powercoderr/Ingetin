package com.example.ingetin;

public class Task {
    private String title;
    private String label;
    private String deadline;
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Task(String title, String label, String deadline, String note) {
        this.title = title;
        this.label = label;
        this.deadline = deadline;
        this.note = note;
    }

    //getter

    public String getTitle() {
        return title;
    }

    public String getLabel() {
        return label;
    }

    public String getDeadline() {
        return deadline;
    }

    //setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
