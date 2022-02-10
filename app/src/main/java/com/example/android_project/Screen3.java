package com.example.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_project.databinding.ActivityMainBinding;
import com.example.android_project.databinding.LessonDetailsScreenBinding;

public class Screen3 extends AppCompatActivity {

    private LessonDetailsScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LessonDetailsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intentFromPrevScreen = getIntent();
        Lesson lesson =(Lesson) intentFromPrevScreen.getSerializableExtra("Lesson_Object");
            binding.lessonNumberAndName.setText(lesson.getNumber() + ". " + lesson.getName());
            binding.lessonLength.setText("Length: " + lesson.getLength() + " min");
            binding.lessonDescription.setText(lesson.getDescription());
    }

}
