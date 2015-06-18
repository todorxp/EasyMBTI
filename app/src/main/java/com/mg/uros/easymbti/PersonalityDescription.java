package com.mg.uros.easymbti;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class PersonalityDescription extends ActionBarActivity {

    private Resources res = EasyMBTI.getContext().getResources();
    private String MBTIType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_description);

        Intent activityThatCalled = getIntent();

        MBTIType = activityThatCalled.getStringExtra("Type");

        TextView MBTITypeTextView = (TextView) findViewById(R.id.MBTITypeText);

        MBTITypeTextView.setText(MBTIType);

       // TextView longText = (TextView) findViewById(R.id.type_description_long_text);
        //  longText.setText(types.getString(mbtiCode));




     //   Log.v("ENFJ", fix);

    }

    /*
    private String findTypeDecsriptionText(String MBTIType)
    {
        String txt;
        TypedArray types = res.obtainTypedArray(R.array.PersonalityTypes);

        if (MBTIType.equals("ESFJ"))
        {

             txt = types.getString(0);
        }

        return txt;
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personality_description, menu);
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

    public void onBackToQuestions(View view) {

        finish();
    }

    public void onTypeDescriptionClick(View view) {

        TypedArray types = res.obtainTypedArray(R.array.PersonalityTypes);

        int mbtiCode = Score.FindPersonalityCode(MBTIType);

        String typeURL = types.getString(mbtiCode);

        types.recycle();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(typeURL));

        startActivity(browserIntent);
    }
}
