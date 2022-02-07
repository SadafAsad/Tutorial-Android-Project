package com.example.android_project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LessonAdapter extends BaseAdapter {
    private Context context;
    private Lesson lessons[];
    private LayoutInflater inflater;

    public LessonAdapter(Context context, Lesson[] lessons) {
        this.context = context;
        this.lessons = lessons;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return lessons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.lessons[i].getStatus()){
            view = inflater.inflate(R.layout.lesson_card_finished, null);
            TextView lesson_number = (TextView) view.findViewById(R.id.lesson_number);
            TextView lesson_name = (TextView) view.findViewById(R.id.lesson_name);
            TextView lesson_length = (TextView) view.findViewById(R.id.lesson_length);
            ImageView finished = (ImageView) view.findViewById(R.id.lesson_status);
            lesson_number.setText(this.lessons[i].getNumber() + "");
            lesson_name.setText(this.lessons[i].getName());
            lesson_length.setText("Length: " + lessons[i].getLength() + " min");
            finished.setImageResource(R.drawable.lesson_finished);
        }
        else {
            view = inflater.inflate(R.layout.lesson_card_not_finished, null);
            TextView lesson_number = (TextView) view.findViewById(R.id.lesson_number);
            TextView lesson_name = (TextView) view.findViewById(R.id.lesson_name);
            TextView lesson_length = (TextView) view.findViewById(R.id.lesson_length);
            lesson_number.setText(this.lessons[i].getNumber() + "");
            lesson_name.setText(this.lessons[i].getName());
            lesson_length.setText("Length: " + lessons[i].getLength() + " min");
        }
        return view;
    }

}
