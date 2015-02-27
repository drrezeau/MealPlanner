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
    String getEntree() {
        return entree;
    }

    String getSide1() {
        return side1;
    }

    String getSide2() {
        return side2;
    }

    String getCereal() {
        return cereal;
    }

    String getFruit() {
        return fruit;
    }

    //Setters
    void setEntree(String temp) {
        entree = temp;
    }

    void setSide1(String temp) {
        side1 = temp;
    }

    void setSide2(String temp) {
        side2 = temp;
    }

    void setCereal(String temp) {
        cereal = temp;
    }

    void setFruit(String temp) {
        fruit = temp;
    }

    public void run(Context context) {



        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {

            //Builds the XML Document Buildera
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();

            InputStream is = context.getAssets().open("breakfast.xml");

            Document dom = DB.parse(is);

            System.out.println(":)");
            NodeList nListEntry = dom.getElementsByTagName("entree");
            Element entryElement = (Element) nListEntry.item(0);

            NodeList nListEntry1 = entryElement.getElementsByTagName("item");
            Element entryElement1 = (Element) nListEntry1.item(1);

            System.out.println("lksuhfoisdfaoisdfhsao" + entryElement1.getTextContent());


        }catch (IOException ex) {
            System.out.println("1COULDN'T OPEN FILE??????????????????????????????????");
        }
        catch (Exception ex) {
            System.out.println("3COULDN'T OPEN FILE??????????????????????????????????");
        }
    }
}