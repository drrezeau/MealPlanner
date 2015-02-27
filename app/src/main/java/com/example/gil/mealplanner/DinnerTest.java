package com.example.gil.mealplanner;

import junit.framework.TestCase;

/**
 * Created by Gil on 2/27/15.
 */
public class DinnerTest extends TestCase {

    Dinner mealD = new Dinner();

    public void testSides() {
        mealD.setSide1("Potato Soup");
        mealD.setSide2("French Salad");
        assertEquals("Potato Soup", mealD.getSide1());
        assertEquals("French Salad", mealD.getSide2());
    }

    public void testEntree() {
        mealD.setEntree("Steak");
        assertEquals("Steak", mealD.getEntree());
    }

    public void testMeal() {
        mealD.setMeal("Steak", "Ceasar Salad", "French Soup", "Broccoli", "Pudding");
        assertEquals("Steak", mealD.getEntree());
        assertEquals("French Soup", mealD.getSide2());
        assertEquals("Ceasar Salad", mealD.getSide1());
        assertEquals("Broccoli", mealD.getVeg());
        assertEquals("Pudding", mealD.getDessert());
    }

    public void testDisplayEandS() {
        System.out.println(mealD.getEntree());
        System.out.println(mealD.getSide1());
        System.out.println(mealD.getSide2());
    }

    public void testDisplay() {
        System.out.println(mealD.returnMeal());

    }
}