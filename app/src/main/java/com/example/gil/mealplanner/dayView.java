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
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class dayView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        Intent intent =  getIntent();

        String date= intent.getStringExtra("date");
        setTitle(date);


        //listview stuff - still needs a new activity
       Breakfast breakfast = new Breakfast();
        ArrayList<String> array;
        array = breakfast.getArrayOfOptions(this, "entree", "breakfast");

        ListView l = (ListView) findViewById(R.id.breakfastList);
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<>(dayView.this,
                android.R.layout.simple_list_item_1, array);
        l.setAdapter(adapter);


        Lunch lunch = new Lunch();
        ArrayList<String> array1;
        array1 = lunch.getArrayOfOptions(this, "salad", "lunch");

        ListView l1 = (ListView) findViewById(R.id.lunchList);
        ArrayAdapter<String> adapter1;

        adapter1 = new ArrayAdapter<>(dayView.this,
                android.R.layout.simple_list_item_1, array1);
        l1.setAdapter(adapter1);

        Dinner dinner = new Dinner();
        ArrayList<String> array2;
        array2 = dinner.getArrayOfOptions(this, "dessert", "dinner");

        ListView l2 = (ListView) findViewById(R.id.dinnerList);
        ArrayAdapter<String> adapter2;

        adapter2 = new ArrayAdapter<>(dayView.this,
                android.R.layout.simple_list_item_1, array2);
        l2.setAdapter(adapter2);

        // More messing around
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                     @Override
                                     public void onItemClick(AdapterView<?> parent, View view, int position,
                                                             long id) {

                                         String item = ((TextView) view).getText().toString();

                                         Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                                     }
                                 });

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void test(View view) {
       /* DinnerTest test = new DinnerTest();

        test.testEntree();
        test.testSides();
        test.testDisplayEandS();

        test.testMeal();
        test.testDisplay();*/
    }

}
