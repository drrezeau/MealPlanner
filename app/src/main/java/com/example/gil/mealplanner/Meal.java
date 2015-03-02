package com.example.gil.mealplanner;

import android.content.Context;
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
    public ArrayList<String> getArrayOfOptions(Context context, String type, String meal) {

        ArrayList<String> array = new ArrayList<>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

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
