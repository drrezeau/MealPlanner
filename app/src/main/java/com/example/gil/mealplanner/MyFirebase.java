package com.example.gil.mealplanner;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gil on 3/9/15.
 */
public class MyFirebase {

    public ArrayList<String> myList = new ArrayList<>();
    public static String entree;
    public static String side1;
    public static String side2;
    public static String cereal;
    public static String fruit;

    public void Firebase(Firebase ref) {

        Firebase ref1 = ref.child("Fort Worth").child("2015").child("March").child("10").child("Breakfast").child("Entree");
        ref1.addValueEventListener(new ValueEventListener() {
            String values;

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                values = (String) snapshot.getValue();
                MyFirebase.entree = this.values;
                System.out.println(snapshot.getValue());
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });
        System.out.println(entree);



        Firebase side1 = ref.child("Fort Worth").child("2015").child("March").child("10").child("Breakfast").child("Side1");
        side1.addValueEventListener(new ValueEventListener() {
            String values;

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                values = (String) snapshot.getValue();
                MyFirebase.side1 = this.values;
                System.out.println(snapshot.getValue());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });

        Firebase side2 = ref.child("Fort Worth").child("2015").child("March").child("10").child("Breakfast").child("Side2");
        side2.addValueEventListener(new ValueEventListener() {
            String values;

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                values = (String) snapshot.getValue();
                MyFirebase.side2 = this.values;
                System.out.println(snapshot.getValue());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });

        Firebase cereal = ref.child("Fort Worth").child("2015").child("March").child("10").child("Breakfast").child("Cereal");
        cereal.addValueEventListener(new ValueEventListener() {
            String values;

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                values = (String) snapshot.getValue();
                MyFirebase.cereal = this.values;
                System.out.println(snapshot.getValue());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });

        Firebase fruit = ref.child("Fort Worth").child("2015").child("March").child("10").child("Breakfast").child("Fruit");
        fruit.addValueEventListener(new ValueEventListener() {
            String values;

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                values = (String) snapshot.getValue();
                MyFirebase.fruit = this.values;
                System.out.println(snapshot.getValue());

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }

        });

    }


    public void setBreakky() {

        myList.clear();
        myList.add(entree);
        myList.add(side1);
        myList.add(side2);
        myList.add(cereal);
        myList.add(fruit);
//        System.out.println(entree);
//        System.out.println(side1);
//        System.out.println(side2);
//        System.out.println(cereal);
//        System.out.println(fruit);



    }
}
