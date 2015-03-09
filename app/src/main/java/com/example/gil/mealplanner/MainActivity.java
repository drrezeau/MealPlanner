package com.example.gil.mealplanner;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

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

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (CalendarView) findViewById(R.id.calendarView);

        setTitle("Fort Worth");

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

                    intent.putExtra("date", dayOfMonth + " " + sMonth + " " + year);
                    startActivity(intent);
                }
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
                return true;
            case R.id.el_paso:
                buildingNumber = 1;
                setTitle("El Paso");
                return true;
            case R.id.snyder:
                buildingNumber = 2;
                setTitle("Snyder");
                return true;
            case R.id.amarillo:
                buildingNumber = 3;
                setTitle("Amarillo");
                return true;
            case R.id.hobbs:
                buildingNumber = 4;
                setTitle("Hobbs");
                return true;
            case R.id.los_lunas:
                buildingNumber = 5;
                setTitle("Los Lunas");
                return true;
            case R.id.carlsbad:
                buildingNumber = 6;
                setTitle("Carlsbad");
                return true;
            case R.id.artesia:
                buildingNumber = 7;
                setTitle("Artesia");
                return true;
            case R.id.lovington:
                buildingNumber = 8;
                setTitle("Lovington");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
