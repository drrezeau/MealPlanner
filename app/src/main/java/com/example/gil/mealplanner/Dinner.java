package com.example.gil.mealplanner;


/**
 * Created by Gil on 2/27/15.
 */
public class Dinner {
    private String entree;
    private String side1;
    private String side2;
    private String veg;
    private String dessert;

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getSide1() {
        return side1;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public String getSide2() {
        return side2;
    }

    public void setSide2(String side2) {
        this.side2 = side2;
    }

    public String getVeg() {
        return veg;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String returnMeal() {
        String meal = "Entree: " + entree
                + "\nSide 1: " + side1
                + "\nSide 2: " + side2
                + "\nVeggie: " + veg
                + "\nDessert: "+ dessert + "\n";
        return meal;
    }

    public void setMeal(String entree, String side1, String side2, String veg, String dessert) {
        setEntree(entree);
        setSide1(side1);
        setSide2(side2);
        setVeg(veg);
        setDessert(dessert);
    }
}
