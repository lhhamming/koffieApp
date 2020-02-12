package com.example.koffieapp;

import com.example.koffieapp.Classes.Coffee;
import com.example.koffieapp.Classes.User;

import java.util.ArrayList;

public class DataProfiler {
    private static DataProfiler instance;
    private ArrayList<User> usersList;
    private ArrayList<Coffee> coffeeList;

    private DataProfiler(){
        initialize();
    }

    private void initialize() {
        usersList = new ArrayList<>();
        coffeeList = new ArrayList<>();
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

    public void addCoffee(String name, int fillsCupTo, boolean canAddSugar, boolean canAddMilk){
        Coffee c = new Coffee(name, fillsCupTo,canAddSugar,canAddMilk);
        coffeeList.add(c);
    }

    public ArrayList<Coffee> getCoffeeList() {return coffeeList;}


}
