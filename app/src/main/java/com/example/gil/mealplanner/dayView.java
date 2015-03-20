package com.example.gil.mealplanner;

//import android.app.ActionBar;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

//import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

public class dayView extends ActionBarActivity {

    String month;
    String building;
    String day;
    String year;
    private ProgressDialog progress;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        //sets the title to the given date
        String date = intent.getStringExtra("date");
        setTitle(date);

        month = intent.getStringExtra("month");
        building = intent.getStringExtra("building");
        day = intent.getStringExtra("day");
        year = intent.getStringExtra("year");

        Log.i("Passed information", month + ' ' + year + ' ' + day + ' ' +  building);

        /*************************************************************************
         * Creates the 3 tabs
         *************************************************************************/
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1"); // Can also add the images here
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");

        tab1.setIndicator("Breakfast").setContent(R.id.tab1);
        tab2.setIndicator("Lunch").setContent(R.id.tab2);
        tab3.setIndicator("Dinner").setContent(R.id.tab3);
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);


        new createListView().execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class createListView extends AsyncTask<String, String, String> {

        public ArrayAdapter<String> adapter;
        public ArrayAdapter<String> adapter1;
        public ArrayAdapter adapter2;
        public ListView l;
        public ListView l1;
        public ListView l2;
        public ArrayList<String> array;
        public ArrayList<String> array1;
        public ArrayList array2;

        @Override
        protected void onPreExecute() {
            l = (ListView) findViewById(R.id.breakfastList);

            //onClickListener of the first tab
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(dayView.this, activity_option_view.class);
                    Integer i = position;  // The position of the item in the listView

                    String item = ((TextView) view).getText().toString();

                    intent.putExtra("month", month);
                    Log.e("BUILDING", building);
                    intent.putExtra("building", building);
                    intent.putExtra("day", day);
                    intent.putExtra("year", year);

                    intent.putExtra("currentOption", item);
                    intent.putExtra("meal", "breakfast");
                    intent.putExtra("index", i.toString());
                    intent.putExtra("option", i.toString());
                    startActivity(intent);

//                    progress = new ProgressDialog(dayView.this);
//                    progress.setTitle("Loading");
//                    progress.setMessage("Wait while loading...");
//                    progress.show();
                }
            });

            ///////////////////////////////////////////////////////////////////////////////////////
            l1 = (ListView) findViewById(R.id.lunchList);

            //onClickListener of the second tab
            l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(dayView.this, activity_option_view.class);
                    Integer i = position;  // The position of the item in the listView


                    String item = ((TextView) view).getText().toString();


                    intent.putExtra("month", month);
                    intent.putExtra("building", building);
                    intent.putExtra("day", day);
                    intent.putExtra("year", year);

                    intent.putExtra("currentOption", item);
                    intent.putExtra("index", i.toString());
                    intent.putExtra("meal", "lunch");
                    startActivity(intent);

//                    progress = new ProgressDialog(dayView.this);
//                    progress.setTitle("Loading");
//                    progress.setMessage("Wait while loading...");
//                    progress.show();
                }
            });

                    ///////////////////////////////////////////////////////////////////////////////////////
                    l2 = (ListView) findViewById(R.id.dinnerList);

                    //onClickListener of the third tab
                    l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(dayView.this, activity_option_view.class);
                    Integer i = position;  // The position of the item in the listView

                    String item = ((TextView) view).getText().toString();



                    intent.putExtra("month", month);
                    intent.putExtra("building", building);
                    intent.putExtra("day", day);
                    intent.putExtra("year", year);

                    intent.putExtra("currentOption", item);
                    intent.putExtra("meal", "dinner");
                    intent.putExtra("index", i.toString());
                    intent.putExtra("option", i.toString());
                    startActivity(intent);

//                            progress = new ProgressDialog(dayView.this);
//                            progress.setTitle("Loading");
//                            progress.setMessage("Wait while loading...");
//                            progress.show();
                }
            });
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, ArrayList> Year = MainActivity.Building.get(year);
            ArrayList<HashMap> list = Year.get(month);

            HashMap<String, HashMap> Month = new HashMap<>();

            for (Integer i = 1; i < list.size(); i++) {
                Month.put(i.toString(), list.get(i));
//                    MainActivity.myMonth.put(i.toString(), list.get(i));
            }

            HashMap dayMap = Month.get(day);

            HashMap<String, String> meal = (HashMap) dayMap.get("Breakfast");
            array = setBreakfastList(meal);
            meal = (HashMap) dayMap.get("Lunch");
            array1 = setLunchList(meal);
            meal = (HashMap) dayMap.get("Dinner");
            array2 = setDinnerList(meal);

            adapter = new ArrayAdapter<>(dayView.this, android.R.layout.simple_list_item_1, array);
            l.setAdapter(adapter);

            adapter1 = new ArrayAdapter<>(dayView.this,
                    android.R.layout.simple_list_item_1, array1);
            l1.setAdapter(adapter1);

            adapter2 = new ArrayAdapter<>(dayView.this,
                    android.R.layout.simple_list_item_1, array2);
            l2.setAdapter(adapter2);

            return null;
        }

        protected void onPostExecute(String result) {

        }

        public ArrayList setBreakfastList(HashMap<String, String> meal) {
            Breakfast myMeal = new Breakfast();

            String type = meal.get("Entree");
            myMeal.setEntree(type);

            type = meal.get("Side1");
            myMeal.setSide1(type);

            type = meal.get("Side2");
            myMeal.setSide2(type);

            type = meal.get("Cereal");
            myMeal.setCereal(type);

            type = meal.get("Fruit");
            myMeal.setFruit(type);

            return myMeal.returnMeal();
        }

        public ArrayList setLunchList(HashMap<String, String> meal) {
            Lunch myMeal = new Lunch();

            String type = meal.get("Entree");
            myMeal.setEntree(type);

            type = meal.get("Side1");
            myMeal.setSalad(type);

            type = meal.get("Side2");
            myMeal.setStarch(type);

            type = meal.get("Vegetable");
            myMeal.setVeg(type);

            type = meal.get("Dessert");
            Log.e("Lunch", myMeal.getEntree());
            myMeal.setDessert(type);

            return myMeal.returnMeal();
        }
        public ArrayList setDinnerList(HashMap<String, String> meal) {
            Dinner myMeal = new Dinner();

            String type = meal.get("Entree");;
            myMeal.setEntree(type);

            type = meal.get("Soup");
            myMeal.setSide1(type);

            type = meal.get("Garnish");
            myMeal.setVeg(type);

            type = meal.get("Dessert");
            myMeal.setDessert(type);

            return myMeal.returnMeal();
        }
    }

}