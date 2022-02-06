package com.example.android_project;

public class Lesson {
    private int number;
    private String name;
    private int length;
    private boolean status;

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

    public void setStatus(){ this.status = true; }
}
