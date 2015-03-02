package com.example.gil.mealplanner;

public class Dinner extends Meal{
    private String entree;
    private String side1;
    private String side2;
    private String veg;
    private String dessert;

    //Setters
    public String getEntree() {
        return entree;
    }

    public String getSide1() {
        return side1;
    }

    public String getSide2() {
        return side2;
    }

    public String getVeg() {
        return veg;
    }

    public String getDessert() {
        return dessert;
    }

    public String returnMeal() {
        String meal = "Entree: " + entree
                + "\nSide 1: " + side1
                + "\nSide 2: " + side2
                + "\nVeggie: " + veg
                + "\nDessert: "+ dessert + "\n";
        return meal;
    }

    //Getters
    public void setEntree(String entree) {
        this.entree = entree;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public void setSide2(String side2) {
        this.side1 = side2;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void setMeal(String entree, String side1, String side2, String veg, String dessert) {
        setEntree(entree);
        setSide1(side1);
        setSide2(side2);
        setVeg(veg);
        setDessert(dessert);
    }
}
