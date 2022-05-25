package com.java.swuchunky;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

public class userAccount {
    public static String email;
    private String pwd;
    private String name;
    private String idToken;
    private String role;
    private int hour;

    //public userAccount(){}
    /*@Override
    public void onCreate() {
        //전역 변수 초기화
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }*/


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int time) {
        this.hour = time;
    }
}
