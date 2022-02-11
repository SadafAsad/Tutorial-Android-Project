package com.example.android_project;

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
        Lesson lesson =(Lesson) intentFromPrevScreen.getSerializableExtra("Lesson_Object");
            binding.lessonNumberAndName.setText(lesson.getNumber() + ". " + lesson.getName());
            binding.lessonLength.setText("Length: " + lesson.getLength() + " min");
            binding.lessonDescription.setText(lesson.getDescription());


        binding.watchLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(lesson.getUrl()));
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

    }


}
