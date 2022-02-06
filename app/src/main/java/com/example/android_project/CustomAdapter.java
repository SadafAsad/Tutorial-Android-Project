package com.example.android_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    Lesson lessons[];
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, Lesson[] lessons) {
        this.context = context;
        this.lessons = lessons;
        inflater = (LayoutInflater.from(applicationContext));
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
        view = inflater.inflate(R.layout.lesson_card_not_finished, null);
        TextView lesson_number = (TextView) view.findViewById(R.id.lesson_number);
        TextView lesson_name = (TextView) view.findViewById(R.id.lesson_name);
        TextView lesson_length = (TextView) view.findViewById(R.id.lesson_length);
        lesson_number.setText(lessons[i].getNumber());
        lesson_name.setText(lessons[i].getName());
        lesson_length.setText("Length: "+lessons[i].getLength()+" min");
        return view;
    }
}
