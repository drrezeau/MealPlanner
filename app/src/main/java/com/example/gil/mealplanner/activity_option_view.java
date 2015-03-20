package com.example.gil.mealplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;


public class activity_option_view extends ActionBarActivity {

    String month;
    String building;
    String day;
    String year;
    String meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_option_view);

        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String currentOption = intent.getStringExtra("currentOption");
        setTitle(currentOption);  // what the current option is

        String index = intent.getStringExtra("index"); //
        // 0 the first tag with the xml, 1 for the second, etc.

        meal = intent.getStringExtra("meal");
        month = intent.getStringExtra("month");
        building = intent.getStringExtra("building");
        day = intent.getStringExtra("day");
        year = intent.getStringExtra("year");

        loadListView(index);

    }

    /**
     * Loads the file which has been parsed into the listView
     * @param index1 the index for which part of the meal we are changing
     */
    public void loadListView(String index1) {

        ArrayList<String> array = new ArrayList<String>();
        ListView list;
        ArrayAdapter<String> adapter;
        final int index = Integer.parseInt(index1);

        if (meal.equals("breakfast")) {
            Breakfast breakfast = new Breakfast();
            array = breakfast.getArrayOfOptions(this, index, meal);
        }
        else if (meal.equals("lunch")) {
            Lunch lunch = new Lunch();
            array = lunch.getArrayOfOptions(this, index, meal);
        }
        else if (meal.equals("dinner")) {
                Dinner dinner = new Dinner();
                array = dinner.getArrayOfOptions(this, index, meal);
        }

        list = (ListView) findViewById(R.id.options);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = ((TextView) view).getText().toString();

//                Log.e("date", month);
//                Log.e("date", day);
//                Log.e("date", building);
//                Log.e("date", year);

                Firebase ref = new Firebase("https://sweltering-heat-3046.firebaseio.com");

                String type = getType(index);


                type = toTitleCase(type);
                meal = toTitleCase(meal);
//                Log.e("newDate", type);

                Firebase ref1 = ref.child(building).child(year).child(month).child(day).child(meal).child(type);

                ref1.setValue(item);
//                Log.e("path", ref1.getPath().toString());
                Intent RI = new Intent();
                RI.putExtra("newItem", item);
                RI.putExtra("index", index);
                RI.putExtra("meal", meal);
                setResult(RESULT_OK, RI);

                finish();
            }

        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_option_view, menu);
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

    /**
     * Exchanges the int of the index to a String depending on which meal you
     * are changing
     * @param num the index of the meal
     * @return type; which is found using the index
     */
    private String getType(int num) {
        String type = "";
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
        return type;
    }

    /**
     * Takes the given String and changes it to TitleCase
     * @param input the String to change
     * @return the String in TitleCase
     */
    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }
}
