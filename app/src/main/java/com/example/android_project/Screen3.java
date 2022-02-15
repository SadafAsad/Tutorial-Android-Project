package com.example.android_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
        int lesson_index = (int) intentFromPrevScreen.getSerializableExtra("selected_lesson_id");
            binding.lessonNumberAndName.setText(ListOfLessons.getInstance().getLessonsList()[lesson_index].getNumber() +
                                                ". " + ListOfLessons.getInstance().getLessonsList()[lesson_index].getName());
            binding.lessonLength.setText("Length: " +
                                        ListOfLessons.getInstance().getLessonsList()[lesson_index].getLength() + " min");
            binding.lessonDescription.setText(ListOfLessons.getInstance().getLessonsList()[lesson_index].getDescription());

            SharedPreferences sp = getSharedPreferences("lesson"+lesson_index+"notes",MODE_PRIVATE);
            binding.notesText.setText(sp.getString("note", ""));


        binding.watchLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = ListOfLessons.getInstance().getLessonsList()[lesson_index].getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        binding.saveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("lesson"+lesson_index+"notes",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("note", binding.notesText.getText().toString());
                editor.apply();
            }
        });

        binding.markComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListOfLessons.getInstance().getLessonsList()[lesson_index].setStatus();
                Intent intent = new Intent(Screen3.this, Screen2.class);
                startActivity(intent);
            }
        });

    }


}
