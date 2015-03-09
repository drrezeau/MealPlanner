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

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

public class dayView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        Intent intent = getIntent();

        //sets the title to the given date
        String date = intent.getStringExtra("date");
        setTitle(date);

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

        /*************************************************************************
         * I will know what tab im on based on what listview's setonclicklistener is called
         *************************************************************************/
        ArrayList<String> array = MainActivity.me.myList; // <-------- David. populate this array with the breakfast info online

        Breakfast breakfast = new Breakfast();
//        array = breakfast.getArrayOfOptions(this, "entree", "breakfast");

        ListView l = (ListView) findViewById(R.id.breakfastList);
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<>(dayView.this, android.R.layout.simple_list_item_1, array);
        l.setAdapter(adapter);

        //onClickListener of the first tab
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), String.valueOf(id), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(dayView.this, activity_option_view.class);
                Integer i = position;  // The position of the item in the listView

                String item = ((TextView) view).getText().toString(); //

                intent.putExtra("meal", "breakfast");
                intent.putExtra("option", i.toString());
                startActivity(intent);
            }
        });


        /*************************************************************************
         * I will know what tab im on based on what listview's setonclicklistener is called
         *************************************************************************/
        Lunch lunch = new Lunch();
        ArrayList<String> array1; // <-------- and this
        array1 = lunch.getArrayOfOptions(this, "salad", "lunch");

        ListView l1 = (ListView) findViewById(R.id.lunchList);
        ArrayAdapter<String> adapter1;

        adapter1 = new ArrayAdapter<>(dayView.this,
                android.R.layout.simple_list_item_1, array1);
        l1.setAdapter(adapter1);

        //onClickListener of the second tab
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), String.valueOf(id), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(dayView.this, activity_option_view.class);
                Integer i = position;  // The position of the item in the listView

                String item = ((TextView) view).getText().toString(); //

                intent.putExtra("currentOption", item);
                intent.putExtra("index", i.toString());
                intent.putExtra("meal", "lunch");
                startActivity(intent);
            }
        });


        /*************************************************************************
         * I will know what tab im on based on what listview's setonlciklistener is called
         *************************************************************************/
        Dinner dinner = new Dinner();
        ArrayList<String> array2; // <-------- and this
        array2 = dinner.getArrayOfOptions(this, "dessert", "dinner");

        ListView l2 = (ListView) findViewById(R.id.dinnerList);
        ArrayAdapter<String> adapter2;

        adapter2 = new ArrayAdapter<>(dayView.this,
                android.R.layout.simple_list_item_1, array2);
        l2.setAdapter(adapter2);

        //onClickListener of the third tab
        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), String.valueOf(id), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(dayView.this, activity_option_view.class);
                Integer i = position;  // The position of the item in the listView

                String item = ((TextView) view).getText().toString(); //

                intent.putExtra("meal", "dinner");
                intent.putExtra("option", i.toString());
                startActivity(intent);
            }
        });
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
    }
}
       /* DinnerTest test = new DinnerTest();

        test.testEntree();
        test.testSides();
        test.testDisplayEandS();

        test.testMeal();
        test.testDisplay();*/

 /*   public ArrayList<String> Firebase(String building, String meal, String month, String day, String year) {

        MyFirebase me = new MyFirebase();

        me.Firebase(building, meal, month, day, year);
        System.out.println(me.entree + " " + me.fruit);

        return me.setBreakky();
    }

}*/


/*
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
*/