package com.example.gil.mealplanner;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class MainActivity extends ActionBarActivity {

    CalendarView cal;
     /*****************
     * Number corresponds to building
     * 0 - Fort Worth
     * 1 - El Paso
     * 2 - Snyder
     * 3 - Amarillo
     * 4 - Hobbs
     * 5 - Los Lunas
     * 6 - Carlsbad
     * 7 - Artesia
     * 8 - Lovington
     ******************/
    int buildingNumber = 0;

    Firebase ref;
    Firebase ref1;
    public static HashMap<String, HashMap> Building;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        ref = new Firebase("https://sweltering-heat-3046.firebaseio.com");
        ref1 = ref.child("Fort Worth");


        cal = (CalendarView) findViewById(R.id.calendarView);

        setTitle("Fort Worth");

        newFirebase();

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            long date = cal.getDate();

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                if (cal.getDate() != date) {

                    Context context = cal.getContext();

                    Intent intent = new Intent();
                    intent.setClass(context, dayView.class);
                    String sMonth = new String();
                    switch (month) {
                        case 0:
                            sMonth = "January";
                            break;
                        case 1:
                            sMonth = "February";
                            break;
                        case 2:
                            sMonth = "March";
                            break;
                        case 3:
                            sMonth = "April";
                            break;
                        case 4:
                            sMonth = "May";
                            break;
                        case 5:
                            sMonth = "June";
                            break;
                        case 6:
                            sMonth = "July";
                            break;
                        case 7:
                            sMonth = "August";
                            break;
                        case 8:
                            sMonth = "September";
                            break;
                        case 9:
                            sMonth = "October";
                            break;
                        case 10:
                            sMonth = "November";
                            break;
                        case 11:
                            sMonth = "December";
                            break;
                    }

                    date = cal.getDate();

                    Integer dayX = dayOfMonth;
                    Integer yearX = year;
                    intent.putExtra("date", dayOfMonth + " " + sMonth + " " + year);
                    intent.putExtra("month", sMonth);
                    intent.putExtra("building", getTitle());
                    intent.putExtra("day", dayX.toString());
                    intent.putExtra("year", yearX.toString());

                    startActivity(intent);
                }
            }
        });
    }

    private void newFirebase() {

//        Firebase ref = new Firebase("https://sweltering-heat-3046.firebaseio.com");
        Firebase ref1 = ref.child("Fort Worth");//.child("2016").child("January");

        ref1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Building = (HashMap) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fort_worth:
                buildingNumber = 0;
                setTitle("Fort Worth");
                ref1 = ref.child("Fort Worth");
                return true;
            case R.id.el_paso:
                buildingNumber = 1;
                setTitle("El Paso");
                ref1 = ref.child("El Paso");
                return true;
            case R.id.snyder:
                buildingNumber = 2;
                setTitle("Snyder");
                ref1 = ref.child("Snyder");
                return true;
            case R.id.amarillo:
                buildingNumber = 3;
                setTitle("Amarillo");
                ref1 = ref.child("Amarillo");
                return true;
            case R.id.hobbs:
                buildingNumber = 4;
                setTitle("Hobbs");
                ref1 = ref.child("Hobbs");
                return true;
            case R.id.los_lunas:
                buildingNumber = 5;
                setTitle("Los Lunas");
                ref1 = ref.child("Los Lunas");
                return true;
            case R.id.carlsbad:
                buildingNumber = 6;
                setTitle("Carlsbad");
                ref1 = ref.child("Carlsbad");
                return true;
            case R.id.artesia:
                buildingNumber = 7;
                setTitle("Artesia");
                ref1 = ref.child("Artesia");
                return true;
            case R.id.lovington:
                buildingNumber = 8;
                setTitle("Lovington");
                ref1 = ref.child("Lovington");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public MyFirebase Firebase() {

        MyFirebase me = new MyFirebase();

        Firebase ref = new Firebase("https://sweltering-heat-3046.firebaseio.com");
        me.Firebase(ref);

        return me;
    }

}
