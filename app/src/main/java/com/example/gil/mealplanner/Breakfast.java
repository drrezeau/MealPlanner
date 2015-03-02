package com.example.gil.mealplanner;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Kendall on 2/25/2015.
 */
public class Breakfast {
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

    /*
    * Parameters: this
    *
    * Function will return an array of options
    */

    public String[] getArrayOfOptions(Context context) {

        String [] array = new String[35];
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder DB = builderFactory.newDocumentBuilder();
            InputStream is = context.getAssets().open("breakfast.xml");
            Document dom = DB.parse(is);

            NodeList nListEntry = dom.getElementsByTagName("entree");
            Element entryElement = (Element) nListEntry.item(0);
            NodeList nListEntry1 = entryElement.getElementsByTagName("option");

            for (int i = 0; i < nListEntry1.getLength() ; i++) {
                Element option = (Element) nListEntry1.item(i);
                array[i] = option.getTextContent();
                System.out.println("Meal: " + option.getTextContent());
            }

        } catch (Exception ex) {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!");
        }

        return array;
    }

    public void run(Context context) {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            //Builds the XML Document Buildera
            DocumentBuilder DB = builderFactory.newDocumentBuilder();

            InputStream is = context.getAssets().open("breakfast.xml");

            Document dom = DB.parse(is);

            System.out.println(":)");
            NodeList nListEntry = dom.getElementsByTagName("entree");
            System.out.println("0");
            Element entryElement = (Element) nListEntry.item(0);
            System.out.println("1");
            NodeList nListEntry1 = entryElement.getElementsByTagName("option");
            System.out.println("2");
            Element entryElement1 = (Element) nListEntry1.item(1);
            System.out.println("3");
            System.out.println("lksuhfoisdfaoisdfhsao" + entryElement1.getTextContent());
            System.out.println("4");

        }catch (IOException ex) {
            System.out.println("1COULDN'T OPEN FILE??????????????????????????????????");
        }
        catch (Exception ex) {
            System.out.println("3COULDN'T OPEN FILE??????????????????????????????????");
        }
    }
}