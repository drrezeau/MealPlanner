package com.example.gil.mealplanner;

public class Lunch extends Meal{
    private String entree;
    private String salad;
    private String starch;
    private String veg;
    private String dessert;

    //Getters
    public String getEntree() {
        return entree;
    }

    public String getSalad() {
        return salad;
    }

    public String getStarch() {
        return starch;
    }

    public String getVeg() {
        return veg;
    }

    public String getDessert() {
        return dessert;
    }

    //Setters
    public void setEntree(String entree) {
        this.entree = entree;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public void setStarch(String starch) {
        this.starch = starch;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void setMeal(String entree, String salad, String starch, String veg, String dessert) {
        setEntree(entree);
        setSalad(salad);
        setStarch(starch);
        setVeg(veg);
        setDessert(dessert);
    }

}
