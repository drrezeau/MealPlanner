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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class activity_option_view extends ActionBarActivity {

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

        String meal = intent.getStringExtra("meal");

        loadListView(index, meal);

    }

    public void loadListView(String index1, String meal) {

        ArrayList<String> array = new ArrayList<>();
        ListView list;
        ArrayAdapter<String> adapter;
        int index = Integer.parseInt(index1);

        switch (meal)
        {
            case "breakfast":
                Breakfast breakfast = new Breakfast();
                array = breakfast.getArrayOfOptions(this, index, meal);
                break;
            case "lunch":
                Lunch lunch = new Lunch();
                array = lunch.getArrayOfOptions(this, index, meal);
                break;
            case "dinner":
                Dinner dinner = new Dinner();
                array = dinner.getArrayOfOptions(this, index, meal);
                break;
        }

        list = (ListView) findViewById(R.id.options);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
}
