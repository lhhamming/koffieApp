package com.example.koffieapp.Classes;

public class Coffee {
    private String name;
    private int id;
    private int fillsCupTo; //This is the amount the cup gets filled in ML. 350 is max.
    private boolean canAddSugar; //Adding sugar to some coffee is a no go.
    private boolean canAddMilk; //Same goes for the milk.

    private static int counter;

    public Coffee(String name, int fillsCupTo, boolean canAddSugar, boolean canAddMilk){
        this.name = name;
        this.fillsCupTo = fillsCupTo;
        this.canAddSugar = canAddSugar;
        this.canAddMilk = canAddMilk;
        counter = counter + 1;
        this.id = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFillsCupTo() {
        return fillsCupTo;
    }

    public void setFillsCupTo(int fillsCupTo) {
        this.fillsCupTo = fillsCupTo;
    }

    public boolean isCanAddSugar() {
        return canAddSugar;
    }

    public void setCanAddSugar(boolean canAddSugar) {
        this.canAddSugar = canAddSugar;
    }

    public boolean isCanAddMilk() {
        return canAddMilk;
    }

    public void setCanAddMilk(boolean canAddMilk) {
        this.canAddMilk = canAddMilk;
    }
}
