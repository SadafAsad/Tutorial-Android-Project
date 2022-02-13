package com.example.android_project;

import java.util.ArrayList;

public class ListOfLessons {

    private Lesson[] lessons_list;

    private static ListOfLessons instance = null;

    // Get the only object available
    public static ListOfLessons getInstance(){
        if (instance==null) {
            instance = new ListOfLessons();
        }
        return instance;
    }

    // Constructor is private to avoiding instantiating
    private ListOfLessons(){
        Lesson lesson1 = new Lesson(1, "Introduction to the Course", 12,
                "In this course, you will learn about Javascript, programming in js, and various applications of it. It is a scripting language, which can be added to our HTML Code using script tag, or by creating a separate file and adding it's location directory.",
                "http://www.youtube.com/watch?v=1HakS7KsbCk");
        Lesson lesson2 = new Lesson(2, "What is Javascript?", 30,
                "JavaScript is a lightweight, cross-platform, and interpreted scripting language. It is well-known for the development of web pages, many non-browser environments also use it. JavaScript can be used for Client-side developments as well as Server-side developments.",
                "http://www.youtube.com/watch?v=upDLs1sn7g4");
        Lesson lesson3 = new Lesson(3, "Variables and Conditionals", 80,
                "In this module, you will learn about variables and conditionals in Javascript. Variables are important because they allow you to programmatically store data. Conditionals are useful for making choices.",
                "http://www.youtube.com/watch?v=qK3yEwXqaAc");
        Lesson lesson4 = new Lesson(4, "Loops", 38,
                "Loops are handy, if you want to run the same code over and over again, each time with a different value. \n JavaScript supports different kinds of loops:\n" +
                        "\n" +
                        "for - loops through a block of code a number of times\n" +
                        "for/in - loops through the properties of an object\n" +
                        "for/of - loops through the values of an iterable object\n" +
                        "while - loops through a block of code while a specified condition is true\n" +
                        "do/while - also loops through a block of code while a specified condition is true",
                "http://www.youtube.com/watch?v=s9wW2PpJsmQ");
        this.lessons_list = new Lesson[]{lesson1, lesson2, lesson3, lesson4};
    }

    public Lesson[] getLessonsList() {
        return this.lessons_list;
    }

}