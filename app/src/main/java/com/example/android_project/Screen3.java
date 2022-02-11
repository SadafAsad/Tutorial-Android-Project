package com.example.android_project;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_project.databinding.ActivityMainBinding;
import com.example.android_project.databinding.LessonDetailsScreenBinding;

import java.util.List;

public class Screen3 extends AppCompatActivity {

    private LessonDetailsScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LessonDetailsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intentFromPrevScreen = getIntent();
        //Lesson lesson =(Lesson) intentFromPrevScreen.getSerializableExtra("Lesson_Object");
        int lesson_index = (int) intentFromPrevScreen.getSerializableExtra("selected_lesson_id");
            binding.lessonNumberAndName.setText(ListOfLessons.getInstance().getLessonsList()[lesson_index].getNumber() +
                                                ". " + ListOfLessons.getInstance().getLessonsList()[lesson_index].getName());
            binding.lessonLength.setText("Length: " +
                                        ListOfLessons.getInstance().getLessonsList()[lesson_index].getLength() + " min");
            binding.lessonDescription.setText(ListOfLessons.getInstance().getLessonsList()[lesson_index].getDescription());
            // must work on being persist
            binding.notesText.setText(ListOfLessons.getInstance().getLessonsList()[lesson_index].getNotes());


        binding.watchLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ListOfLessons.getInstance().getLessonsList()[lesson_index].getUrl()));
                intent.setPackage("com.google.android.youtube");
                PackageManager manager = getPackageManager();
                List<ResolveInfo> info = manager.queryIntentActivities(intent, 0);
                if (info.size() > 0) {
                    startActivity(intent);
                } else {
                    //No Application can handle your intent
                }

//                Uri uri = Uri.parse(lesson.getUrl()); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                intent.setComponent(new ComponentName("com.google.android.youtube","com.google.android.youtube.PlayerActivity"));
//                startActivity(intent);
            }
        });

        binding.saveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //not persisted yet
                ListOfLessons.getInstance().getLessonsList()[lesson_index].setNotes(binding.notesText.getText().toString());
            }
        });

        binding.markComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListOfLessons.getInstance().getLessonsList()[lesson_index].setStatus();
                // and goes back
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screen3.this, Screen2.class);
                startActivity(intent);
            }
        });

    }


}
