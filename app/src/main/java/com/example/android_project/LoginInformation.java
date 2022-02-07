package com.example.android_project;

public class LoginInformation
{
    private String username;
    private String password;

    public boolean validUsernameCheck()
    {
        if(username.equals("abcd"))
        {
            return true;
        }
        return false;
    }

    public boolean validPasswordCheck()
    {
        if(password.equals("1234"))
        {
            return true;
        }
        return false;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
