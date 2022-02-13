package com.example.android_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

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

        LessonAdapter lessonAdapter = new LessonAdapter(getApplicationContext(), ListOfLessons.getInstance().getLessonsList());
        lessons_list.setAdapter(lessonAdapter);

        onClicks();
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
                SharedPreferences sp = getSharedPreferences("skipLogin",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear().apply();

                Intent intent = new Intent(Screen2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        this.lessons_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                boolean allowed = true;
                if (sequential_progression.isChecked()){
                    for (int j=0; j<i; j++){
                        if (i>0 && !ListOfLessons.getInstance().getLessonsList()[j].getStatus() && !ListOfLessons.getInstance().getLessonsList()[i].getStatus()){
                            Toast toast = Toast.makeText(getApplicationContext(),"Watch the previous lessons first.",Toast.LENGTH_LONG);
                            toast.show();
                            allowed = false;
                            break;
                        }
                    }
                    if (allowed){
                        Intent intent = new Intent(Screen2.this, Screen3.class);
                        //Lesson lesson = new Lesson(ListOfLessons.getInstance().lessonsList()[i].getNumber(),ListOfLessons.getInstance().lessonsList()[i].getName(),ListOfLessons.getInstance().lessonsList()[i].getLength(),ListOfLessons.getInstance().lessonsList()[i].getDescription(),ListOfLessons.getInstance().lessonsList()[i].getUrl());
                        //intent.putExtra("Lesson_Object",lesson);
                        intent.putExtra("selected_lesson_id", i);
                        startActivity(intent);
                        //startActivityForResult(intent, 1);
                    }
                }
                else {
                    Intent intent = new Intent(Screen2.this, Screen3.class);
                    //Lesson lesson = new Lesson(ListOfLessons.getInstance().lessonsList()[i].getNumber(),ListOfLessons.getInstance().lessonsList()[i].getName(),ListOfLessons.getInstance().lessonsList()[i].getLength(),ListOfLessons.getInstance().lessonsList()[i].getDescription(),ListOfLessons.getInstance().lessonsList()[i].getUrl());
                    //intent.putExtra("Lesson_Object",lesson);
                    intent.putExtra("selected_lesson_id", i);
                    startActivity(intent);
                    //startActivityForResult(intent, 1);
                }
            }
        });
    }

}
