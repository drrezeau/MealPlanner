package com.example.gil.mealplanner;

import junit.framework.TestCase;

/**
 * Breakfast getting and setting testing.
 * Created by Kendall */
public class BreakfastTest extends TestCase {
    Breakfast breakfast = new Breakfast();

    public void testSides() {
        breakfast.setSide1("Scrambled Eggs");
        breakfast.setSide2("Bacon");
        breakfast.setCereal("Oatmeal");
        assertEquals("Scrambled Eggs", breakfast.getSide1());
        assertEquals("Bacon", breakfast.getSide2());
        assertEquals("Oatmeal", breakfast.getCereal());
    }

    public void testEntree() {
        breakfast.setEntree("Pancakes");
        assertEquals("Pancakes", breakfast.getEntree());
    }

    public void testMeal() {
        breakfast.setMeal("French Toast", "Scrambled Eggs", "Sausage", "Cream of the West", "Seasonal");
        assertEquals("French Toast", breakfast.getEntree());
        assertEquals("Scrambled Eggs", breakfast.getSide2());
        assertEquals("Sausage", breakfast.getSide2());
        assertEquals("Cream of the West", breakfast.getCereal());
        assertEquals("Seasonal", breakfast.getFruit());
    }

    public void testDisplayEandS() {
        System.out.println(breakfast.getEntree());
        System.out.println(breakfast.getSide1());
        System.out.println(breakfast.getSide2());
    }
}
