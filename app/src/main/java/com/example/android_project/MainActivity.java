package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LoginInformation onlyUser = new LoginInformation("abcd","1234");
    ArrayList <LoginInformation> listOfLogins = new ArrayList<LoginInformation>();

    Switch toggleSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleSwitch = (Switch) findViewById(R.id.toggleButton);

        listOfLogins.add(onlyUser);

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

        if(user.getText().toString().isEmpty() || pass.getText().toString().isEmpty())
        {
            Log.d("error","Any field cannot be left empty");
            err.setText("Any field cannot be left empty");
        }
        else if(!validUsernameCheck(listOfLogins,user.getText().toString()))
        {
            Log.d("abc",user.getText().toString() + listOfLogins);
            Log.d("error","Username does not exist");
            err.setText("Username does not exist");
            user.setText("");
            pass.setText("");
        }
        else if(validUsernameCheck(listOfLogins,user.getText().toString()) && !validPasswordCheck(listOfLogins,user.getText().toString(),pass.getText().toString()))
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

    public boolean validUsernameCheck(ArrayList<LoginInformation> listOfUsers, String usernameEntered)
    {
        for(LoginInformation l1 : listOfUsers)
        {
            if(l1.getUsername().equals(usernameEntered))
            {
                return true;
            }
        }
        return false;
    }

    public boolean validPasswordCheck(ArrayList<LoginInformation> listOfUsers, String usernameEntered, String passwordEntered)
    {
        for(LoginInformation l1 : listOfUsers)
        {
            if(l1.getUsername().equals(usernameEntered) && l1.getPassword().equals(passwordEntered))
            {
                return true;
            }
        }
        return false;
    }

}