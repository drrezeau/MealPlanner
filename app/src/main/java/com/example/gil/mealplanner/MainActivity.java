package com.example.gil.mealplanner;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * This is the open screen which the application first opens to.
 */
public class MainActivity extends ActionBarActivity {

    CalendarView cal;
    /**
     * ****************
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
     * *****************
     */

    private static ProgressDialog progress;
    private int buildingNumber = 0;

    Firebase ref;
    public static Firebase ref1;
    public static HashMap<String, HashMap> Building;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    /**
     * Sets up the activty and calendar widget
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        setBuildingNumber();

        ref = new Firebase("https://sweltering-heat-3046.firebaseio.com");
        ref1 = ref.child("Fort Worth");

        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        setFirebaseOnLoad();

        cal = (CalendarView) findViewById(R.id.calendarView);
        //864000000 for changing the day back one
        long milliTime = cal.getDate()-86400000;
        cal.setDate (milliTime, true, true);


        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            long date = cal.getDate();

            /**
             * Created the listener for the calendar widget
             * @param view na
             * @param year na
             * @param month na
             * @param dayOfMonth na
             */
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                Calendar myDate = Calendar.getInstance();
                Date x = myDate.getTime();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Log.i("Today's Date", format.format(x.getTime()));

                if (cal.getDate() != date) {

                    Context context = cal.getContext();

                    Intent intent = new Intent();
                    intent.setClass(context, dayView.class);
                    String sMonth = "";
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

                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    /**
     * Connects and pulls the data from Firebase
     */
    public static void newFirebase() {
        ref1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Building = (HashMap) dataSnapshot.getValue();
                progress.dismiss();
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

    /**
     * Creates the items to be displayed when the house icon from
     * the action bar is selected
     * @param item na
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int building = item.getItemId();
        switch (item.getItemId()) {
            case R.id.fort_worth:
                buildingNumber = 0;
                setTitle("Fort Worth");
                ref1 = ref.child("Fort Worth");
                break;
            case R.id.el_paso:
                buildingNumber = 1;
                setTitle("El Paso");
                ref1 = ref.child("El Paso");
                break;
            case R.id.snyder:
                buildingNumber = 2;
                setTitle("Snyder");
                ref1 = ref.child("Snyder");
                break;
            case R.id.amarillo:
                buildingNumber = 3;
                setTitle("Amarillo");
                ref1 = ref.child("Amarillo");
                break;
            case R.id.hobbs:
                buildingNumber = 4;
                setTitle("Hobbs");
                ref1 = ref.child("Hobbs");
                break;
            case R.id.los_lunas:
                buildingNumber = 5;
                setTitle("Los Lunas");
                ref1 = ref.child("Los Lunas");
                break;
            case R.id.carlsbad:
                buildingNumber = 6;
                setTitle("Carlsbad");
                ref1 = ref.child("Carlsbad");
                break;
            case R.id.artesia:
                buildingNumber = 7;
                setTitle("Artesia");
                ref1 = ref.child("Artesia");
                break;
            case R.id.lovington:
                buildingNumber = 8;
                setTitle("Lovington");
                ref1 = ref.child("Lovington");
                break;
        }

        if (building != R.id.building) {
            progress = new ProgressDialog(this);
            progress.setTitle("Loading");
            progress.setMessage("Wait while loading...");
            progress.show();



            writeFile();
            setBuildingNumber();
            newFirebase();

            System.out.println("!@#$%^&*()_+ New building");
//            Toast.makeText(this, "I did it!!", Toast.LENGTH_LONG).show();

        }

        return true;
    }

    /**
     * takes the building number and writes it to the file
     */
    public void writeFile() {
        String filename = "buildingNum.txt";
        FileOutputStream outputStream;

        try {
        outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
        String num = Integer.toString(buildingNumber);
        outputStream.write(num.getBytes());
        outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sets the local building number when changing buildings
     * Also writes it to local file for later use.
     */
    public void setBuildingNumber() {

        try {
            FileInputStream inputStream = openFileInput("buildingNum.txt");
            InputStreamReader InputRead = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(InputRead);

            String line =  bufferedReader.readLine();

            buildingNumber = Integer.parseInt(line);
            InputRead.close();
        }  catch (Exception e) {
            buildingNumber = 0;
        }

    }

    /**
     * when changing a building, loads the relevant Firebase data
     */
    private void setFirebaseOnLoad() {
        switch (buildingNumber) {
            case 0:
                ref1 = ref.child("Fort Worth");
                setTitle("Fort Worth");
                break;
            case 1:
                ref1 = ref.child("El Paso");
                setTitle("El Paso");
                break;
            case 2:
                ref1 = ref.child("Snyder");
                setTitle("Snyder");
                break;
            case 3:
                ref1 = ref.child("Amarillo");
                setTitle("Amarillo");
                break;
            case 4:
                ref1 = ref.child("Hobbs");
                setTitle("Hobbs");
                break;
            case 5:
                ref1 = ref.child("Los Lunas");
                setTitle("Los Lunas");
                break;
            case 6:
                ref1 = ref.child("Carlsbad");
                setTitle("Carlsbad");
                break;
            case 7:
                ref1 = ref.child("Artesia");
                setTitle("Artesia");
                break;
            case 8:
                ref1 = ref.child("Lovington");
                setTitle("Lovington");
                break;

        }
        newFirebase();
    }

}
