package com.example.android_project;

public class ListOfLessons {

    // Create an object of ListOfLessons
    private static ListOfLessons instance = new ListOfLessons();

    // Constructor is private to avoiding instantiating
    private ListOfLessons(){}

    // Get the only object available
    public static ListOfLessons getInstance(){
        return instance;
    }

    public Lesson[] lessonsList(){
        Lesson lesson1 = new Lesson(1, "Introduction to the Course", 12,
                                    "Description for first Description for first Description for first Description for first Description for first Description for first Description for first Description for first Description for first", "");
        Lesson lesson2 = new Lesson(2, "What is Javascript?", 30,
                                    "Description for second Description for second Description for second Description for second Description for second Description for second Description for second Description for second Description for second", "");
        Lesson lesson3 = new Lesson(3, "Variables and Conditionals", 80,
                                    "", "");
        Lesson lesson4 = new Lesson(4, "Loops", 38,
                                    "", "");
        Lesson[] lessons = new Lesson[]{lesson1, lesson2, lesson3, lesson4};
        return lessons;
    }

}
