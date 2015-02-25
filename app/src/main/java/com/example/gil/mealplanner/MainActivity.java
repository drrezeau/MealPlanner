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

//import java.util.Calendar;

public class MainActivity extends ActionBarActivity {

    CalendarView cal;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (CalendarView) findViewById(R.id.calendarView);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
//                TODO Auto-generated method stub


                Context context = cal.getContext();

                Intent intent = new Intent();
                intent.setClass(context, dayView.class);
                String sMonth = new String();
                switch (month)
                {
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

                intent.putExtra("date", dayOfMonth + " " + sMonth + " " + year);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
