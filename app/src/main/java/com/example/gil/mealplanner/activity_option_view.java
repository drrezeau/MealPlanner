package com.example.gil.mealplanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class activity_option_view extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_option_view);

        Intent intent = getIntent();
        String currentOption = intent.getStringExtra("currentOption");
        setTitle(currentOption);  // what the current option is

        String index = intent.getStringExtra("index"); //
        // 0 the first tag with the xml, 1 for the second, etc.

        //Toast.makeText(getBaseContext(), currentOption + ": " + index, Toast.LENGTH_LONG).show();

        String meal = intent.getStringExtra("meal");

        loadListView(index, meal);
    }

    public void loadListView(String index, String meal) {

        ArrayList<String> array = new ArrayList<>();
        ListView list;
        ArrayAdapter<String> adapter;

        Toast.makeText(getBaseContext(),"meal" + meal, Toast.LENGTH_LONG).show();


        switch (meal)
        {
            case "breakfast":
                list = (ListView) findViewById(R.id.breakfastList);
                Breakfast breakfast = new Breakfast();
                array = breakfast.getArrayOfOptions(this, "entree", meal);
                break;
            case "lunch":
                list = (ListView) findViewById(R.id.lunchList);
                Lunch lunch = new Lunch();
                array = lunch.getArrayOfOptions(this, "entree", meal);
                break;
            case "dinner":
                list = (ListView) findViewById(R.id.dinnerList);
                Dinner dinner = new Dinner();
                array = dinner.getArrayOfOptions(this, "entree", meal);
                break;
            default: list = (ListView) findViewById(R.id.breakfastList);
        }

        adapter = new ArrayAdapter<>(activity_option_view.this, android.R.layout.simple_list_item_1, array);

        list.setAdapter(adapter); // crashing here
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
