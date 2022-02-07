package com.example.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2 extends AppCompatActivity {

    private Switch sequential_progression;
    private ListView lessons_list;
    private Button logout;
    private Lesson lessons[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list_screen);

        findViews();
        setLessons();
        onClicks();

        LessonAdapter lessonAdapter = new LessonAdapter(getApplicationContext(), lessons);
        lessons_list.setAdapter(lessonAdapter);

        if (this.sequential_progression.isChecked()){
            // don't allow
        }
        else{
            // allow
        }

    }

    private void findViews(){
        this.sequential_progression = (Switch) findViewById(R.id.sequential_progression);
        this.lessons_list = (ListView) findViewById(R.id.lessons_list);
        this.logout = (Button) findViewById(R.id.logout);
    }

    private void onClicks(){
        this.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screen2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        this.lessons_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Screen2.this, Screen3.class);
                startActivity(intent);
            }
        });
    }

    private void setLessons(){
        Lesson lesson1 = new Lesson(1, "Introduction to the Course", 12);
        Lesson lesson2 = new Lesson(2, "What is Javascript?", 30);
        Lesson lesson3 = new Lesson(3, "Variables and Conditionals", 80);
        Lesson lesson4 = new Lesson(4, "Loops", 38);
        this.lessons = new Lesson[]{lesson1, lesson2, lesson3, lesson4};
    }

}
