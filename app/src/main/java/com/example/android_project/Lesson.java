package com.example.android_project;

public class Lesson {
    private int number;
    private String name;
    private int length;
    private boolean status;
    private String description;
    private String notes;

    public Lesson(int number, String name, int length){
        this.number = number;
        this.name = name;
        this.length = length;
        this.status = false;
    }

    public int getNumber(){ return this.number; }
    public String getName(){ return this.name; }
    public int getLength(){ return this.length; }
    public boolean getStatus(){ return this.status; }
    public String getDescription(){ return this.description; }
    public String getNotes(){ return this.notes; }

    public void setStatus(){ this.status = true; }
    public void setNotes(String notes){ this.notes = notes; }
}
