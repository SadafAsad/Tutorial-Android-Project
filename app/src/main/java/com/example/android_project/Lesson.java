package com.example.android_project;

public class Lesson {
    private int number;
    private String name;
    private int length;

    public Lesson(int number, String name, int length){
        this.number = number;
        this.name = name;
        this.length = length;
    }

    public int getNumber(){ return this.number; }
    public String getName(){ return this.name; }
    public int getLength(){ return this.length; }
}
