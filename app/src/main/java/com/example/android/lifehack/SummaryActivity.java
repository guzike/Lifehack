package com.example.android.lifehack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        createSummary();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summary, menu);
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

    public void createSummary(){



        //CheckBox checkBox1 = (CheckBox) findViewById(R.id.check_ans1);
        //boolean check_ans1 = checkBox1.isChecked();

        //CheckBox checkBox2 = (CheckBox) findViewById(R.id.check_ans2);
        //boolean check_ans2 = checkBox2.isChecked();

        //CheckBox checkBox3 = (CheckBox) findViewById(R.id.check_ans3);
        //boolean check_ans3 = checkBox3.isChecked();

        //RadioButton radioButton1 = (RadioButton) findViewById(R.id.yes_radio_button);
        //boolean radio_ans1 = radioButton1.isChecked();

        //RadioButton radioButton2 = (RadioButton) findViewById(R.id.no_radio_button);
        //boolean radio_ans2 = radioButton2.isChecked();

        //TextView summaryText = (TextView) findViewById(R.id.summary_text);
        //summaryText.setText(name);
    }
}
