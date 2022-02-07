package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    LoginInformation onlyUser = new LoginInformation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
    }

    public void signInButton(View view)
    {
        EditText pass = (EditText) findViewById(R.id.password);
        EditText user = (EditText) findViewById(R.id.username);
        TextView err = (TextView)  findViewById(R.id.forError);

        onlyUser.setUsername(user.getText().toString());
        onlyUser.setPassword(pass.getText().toString());

        if(onlyUser.getUsername().isEmpty() || onlyUser.getPassword().isEmpty())
        {
            Log.d("error","Any field cannot be left empty");
            err.setText("Any field cannot be left empty");
        }
        else if(!onlyUser.validUsernameCheck())
        {
            Log.d("error","Username does not exist");
            err.setText("Username does not exist");
            user.setText("");
            pass.setText("");
        }
        else if(onlyUser.validUsernameCheck() && !onlyUser.validPasswordCheck())
        {
            Log.d("error","Username password combination is incorrect");
            err.setText("Username password combination is incorrect");
            user.setText("");
            pass.setText("");
        }
        else
        {
            Log.d("abcd","button pressed");
            Intent intent = new Intent(this, Screen2.class);
            startActivity(intent);
        }

    }
}