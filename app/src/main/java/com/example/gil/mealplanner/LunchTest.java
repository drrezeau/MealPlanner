package com.example.gil.mealplanner;

import static junit.framework.Assert.assertEquals;

/**
 * Lunch getting and setting testing.
 * Created by Shane on 2/28/2015.
 */
public class LunchTest extends Lunch{
    Lunch lunch = new Lunch();

    public void testSides() {
        lunch.setSalad("Cole Slaw");
        lunch.setStarch("Scallop Potato");
        lunch.setVeg("Carrots");
        assertEquals("Cole Slaw", lunch.getSalad());
        assertEquals("Carrots", lunch.getVeg());
        assertEquals("Scallop Potato", lunch.getStarch());
    }

    public void testEntree() {
        lunch.setEntree("Pork Chops");
        assertEquals("PorkChops", lunch.getEntree());
    }

    public void testMeal() {
        lunch.setMeal("Steak", "Ceasar Salad", "Mashed Potato", "Broccoli", "Pudding");
        assertEquals("Steak", lunch.getEntree());
        assertEquals("Mashed Potato", lunch.getStarch());
        assertEquals("Ceasar Salad", lunch.getSalad());
        assertEquals("Broccoli", lunch.getVeg());
        assertEquals("Pudding", lunch.getDessert());
    }
}
