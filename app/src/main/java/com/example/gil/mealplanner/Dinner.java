package com.example.gil.mealplanner;

import java.util.ArrayList;

public class Dinner extends Meal{
    private String entree;
    private String side1;
    private String veg;
    private String dessert;

    //Setters
    public String getEntree() {
        return entree;
    }

    public String getSide1() {
        return side1;
    }

    public String getVeg() {
        return veg;
    }

    public String getDessert() {
        return dessert;
    }

    public ArrayList returnMeal() {
        ArrayList<String> meal = new ArrayList<>();
        meal.add(entree);
        meal.add(side1);
        meal.add(veg);
        meal.add(dessert);
        return meal;
    }

    //Getters
    public void setEntree(String entree) {
        this.entree = entree;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void setMeal(String entree, String side1, String veg, String dessert) {
        setEntree(entree);
        setSide1(side1);
        setVeg(veg);
        setDessert(dessert);
    }
}
