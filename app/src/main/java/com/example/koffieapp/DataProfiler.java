package com.example.koffieapp;

import com.example.koffieapp.Classes.User;

import java.util.ArrayList;

public class DataProfiler {
    private static DataProfiler instance;
    private ArrayList<User> usersList;

    private DataProfiler(){
        initialize();
    }

    private void initialize() {
        usersList = new ArrayList<>();
    }

    public static DataProfiler getInstance(){
        if(instance == null){
            instance = new DataProfiler();
        }
        return instance;
    }

    public void addUser(String name){
        User u = new User(name);
        usersList.add(u);
    }

    public ArrayList<User> getUsersList(){
        return usersList;
    }



}
