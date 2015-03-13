package com.example.gil.mealplanner;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Breakfast extends Meal {
    private String entree;
    private String side1;
    private String side2;
    private String cereal;
    private String fruit;

    //Getters
    public String getEntree() {
   return entree;
    }

    public String getSide1() {
        return side1;
    }

    public String getSide2() {
        return side2;
    }

    public String getCereal() {
        return cereal;
    }

    public String getFruit() {
        return fruit;
    }

    //Setters
    public void setEntree(String temp) {
        entree = temp;
    }

    public void setSide1(String temp) {
        side1 = temp;
    }

    public void setSide2(String temp) {
        side2 = temp;
    }

    public void setCereal(String temp) {
        cereal = temp;
    }

   public void setFruit(String temp) {
        fruit = temp;
    }

    public void setMeal(String entree, String side1, String side2, String cereal, String fruit) {
        setEntree(entree);
        setSide2(side2);
        setSide1(side1);
        setCereal(cereal);
        setFruit(fruit);
    }

    public ArrayList returnMeal() {
        ArrayList<String> meal = new ArrayList<>();
        meal.add(entree);
        meal.add(side1);
        meal.add(side2);
        meal.add(fruit);
        meal.add(cereal);
        return meal;
    }

}