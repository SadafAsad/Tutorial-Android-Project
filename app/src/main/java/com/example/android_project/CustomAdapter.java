package com.example.android_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private Lesson lessons[];
    private LayoutInflater inflater;

    public CustomAdapter(Context context, Lesson[] lessons) {
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
        view = inflater.inflate(R.layout.lesson_card_not_finished, null);
        TextView lesson_number = (TextView) view.findViewById(R.id.lesson_number);
        TextView lesson_name = (TextView) view.findViewById(R.id.lesson_name);
        TextView lesson_length = (TextView) view.findViewById(R.id.lesson_length);
        lesson_number.setText(this.lessons[i].getNumber()+"");
        lesson_name.setText(this.lessons[i].getName());
        lesson_length.setText("Length: "+lessons[i].getLength()+" min");
        return view;
    }
}
