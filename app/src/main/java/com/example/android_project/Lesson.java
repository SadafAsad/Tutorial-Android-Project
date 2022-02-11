package com.example.android_project;

import java.io.Serializable;

public class Lesson implements Serializable {
    private int number;
    private String name;
    private int length;
    private boolean status;
    private String description;
    private String url;

    public Lesson(int number, String name, int length, String description, String url){
        this.number = number;
        this.name = name;
        this.length = length;
        this.status = false;
        this.description = description;
        this.url = url;
    }

    public int getNumber(){ return this.number; }
    public String getName(){ return this.name; }
    public int getLength(){ return this.length; }
    public boolean getStatus(){ return this.status; }
    public String getDescription(){ return this.description; }
    public String getUrl(){ return this.url; }

    public void setStatus(){ this.status = true; }
}
