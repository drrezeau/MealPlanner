package com.example.gil.mealplanner;

/**
 * Created by Shane on 2/28/2015.
 */
public class Lunch {
    private String entree;
    private String salad;
    private String starch;
    private String veg;
    private String dessert;

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public String getStarch() {
        return starch;
    }

    public void setStarch(String starch) {
        this.starch = starch;
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

    public void setMeal(String entree, String salad, String starch, String veg, String dessert) {
        setEntree(entree);
        setSalad(salad);
        setStarch(starch);
        setVeg(veg);
        setDessert(dessert);
    }

}
