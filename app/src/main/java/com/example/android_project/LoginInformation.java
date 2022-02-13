package com.example.android_project;

import com.example.android_project.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class LoginInformation
{
    private String username;
    private String password;

    public LoginInformation(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
