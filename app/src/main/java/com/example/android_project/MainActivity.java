package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.android_project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    LoginInformation onlyUser = new LoginInformation();
    Switch toggleSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        toggleSwitch = (Switch) findViewById(R.id.toggleButton);

        SharedPreferences sp = getSharedPreferences("skipLogin",MODE_PRIVATE);
        boolean skip = sp.getBoolean("toggleButton",false);
        Log.d("abc",String.valueOf(skip));
        if(skip)
        {
            Log.d("abc","button Login successful");
            Intent intent = new Intent(this, Screen2.class);
            startActivity(intent);
        }


        toggleSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleSwitch.isChecked())
                {
                    Log.d("abc","Toggle button checked");
                    SharedPreferences sp = getSharedPreferences("skipLogin",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("toggleButton",true);
                    editor.apply();
                }
                else
                {
                    Log.d("abc","Toggle button unchecked");
                    SharedPreferences sp = getSharedPreferences("skipLogin",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("toggleButton",false);
                    editor.apply();
                }
            }
        });
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
            Log.d("abc","button Login successful");
            Intent intent = new Intent(this, Screen2.class);
            startActivity(intent);
        }

    }

}