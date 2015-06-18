package com.mg.uros.easymbti;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private  int numberOfQuestions;

    private  MBTIQuestion[] MBTIQuestions;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        numberOfQuestions = 28;

        setContentView(R.layout.activity_main);

        // MBTIQuestions is created already and we can get it from savedInstanceState
        if (savedInstanceState != null) {

            MBTIQuestions = (MBTIQuestion[]) savedInstanceState.getSerializable("MBTIQuestions");
        }

        // In case that MBTIQuestions is not created
        if (MBTIQuestions == null) {

            MBTIQuestionArray MBTITest = new MBTIQuestionArray();
            MBTIQuestions = MBTITest.Create(numberOfQuestions);
        }

        // Setting custom adapter, passing MBTIQuestions as value, setting listView
        ListAdapter listAdapter = new MyAdapter(MainActivity.this, MBTIQuestions);

        ListView listView = (ListView) findViewById(R.id.list_view);

      // View findType =  findViewById(R.id.find_type_button);

      //  listView.addFooterView(findType);

        listView.setAdapter(listAdapter);



    }

    // Saving MBTIQuestions Object
    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable("MBTIQuestions", MBTIQuestions);
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
        if (id == R.id.find_type_menu_button) {

            String  MBTIType = Score.CalculateType();



            Intent personalityDescription =  new Intent(this,PersonalityDescription.class);

            personalityDescription.putExtra("Type",MBTIType);

            startActivity(personalityDescription);
            return true;
        }




        return super.onOptionsItemSelected(item);
    }


    public void onFindTypeClick(View view) {




    }
}
