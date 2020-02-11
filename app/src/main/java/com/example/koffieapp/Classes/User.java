package com.example.koffieapp.Classes;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    int coffeeOwned;
    int coffeeDebt;

    public User(String name) {
        this.name = name;
        this.coffeeOwned = coffeeOwned;
        this.coffeeDebt = coffeeDebt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoffeeOwned() {
        return coffeeOwned;
    }

    public void setCoffeeOwned(int coffeeOwned) {
        this.coffeeOwned = coffeeOwned;
    }

    public int getCoffeeDebt() {
        return coffeeDebt;
    }

    public void setCoffeeDebt(int coffeeDebt) {
        this.coffeeDebt = coffeeDebt;
    }

    @Override
    public String toString() {
        return getName() + " \n Koffie gekocht: " + getCoffeeOwned() + " \n Koffie schuld: " + getCoffeeDebt();
    }
}
