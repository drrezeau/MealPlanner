package com.example.gil.mealplanner;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Meal {
    /*
    * Parameters: this, type - i.e. "entree, side1, etc." Whatever the tag name is, and the meal "breakfast" "lunch" or "dinner"
    *
    * Dinner: entree, soup, garnish, dessert
    * Lunch: entree, salad, starch, vegetable, dessert
    * Breakfast: entree, side1, side2, cereal, fruit
    *
    * Function will return an array of options
    */
    public ArrayList<String> getArrayOfOptions(Context context, int num, String meal) {

        Log.e("go team", "index: " + num + "  Meal: " + meal);


        ArrayList<String> array = new ArrayList<String>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        String type = "entree";

        //Log.e("go team", "index: " + num + "  Meal: " + meal + "  type: " + type);

        switch (num) {
            case 0:
                type = "entree";
                break;
            case 1:
                if (meal.equals("dinner"))
                type = "soup";
            else if (meal.equals("lunch"))
                type = "salad";
            else
                type = "side1";
            break;
            case 2:
                if (meal.equals("dinner"))
                    type = "garnish";
                else if (meal.equals("lunch"))
                    type = "starch";
                else
                    type = "side2";
                break;
            case 3:
                if (meal.equals("dinner"))
                    type = "dessert";
                else if (meal.equals("lunch"))
                    type = "vegetable";
                else
                    type = "fruit";
                break;
            case 4:
                if (meal.equals("lunch"))
                    type = "dessert";
                else
                    type = "cereal";
                break;
        }

        try {
            DocumentBuilder DB = builderFactory.newDocumentBuilder();
            InputStream is = context.getAssets().open(meal + ".xml");
            Document dom = DB.parse(is);

            NodeList nListEntry = dom.getElementsByTagName(type);
            Element entryElement = (Element) nListEntry.item(0);
            NodeList nListEntry1 = entryElement.getElementsByTagName("option");

            for (int i = 0; i < nListEntry1.getLength() ; i++) {
                Element option = (Element) nListEntry1.item(i);
                array.add(option.getTextContent());
            }

        } catch (Exception ex) {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!");
        }

        return array;
    }
}
