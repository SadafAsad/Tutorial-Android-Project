package com.example.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list_screen);

        findViews();
        onClicks();

        LessonAdapter lessonAdapter = new LessonAdapter(getApplicationContext(), ListOfLessons.getInstance().lessonsList());
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

}
