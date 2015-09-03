package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String name = extras.getString("name");
        String ansText = extras.getString("ansText");

        boolean check_ans1 = extras.getBoolean("check_ans1");
        boolean check_ans2 = extras.getBoolean("check_ans2");
        boolean check_ans3 = extras.getBoolean("check_ans3");

        boolean radio_ans1 = extras.getBoolean("radio_ans1");
        boolean radio_ans2 = extras.getBoolean("radio_ans2");

        String summary = name + "\n" + ansText + "\n" + check_ans1 + "\n" + check_ans2 + "\n" + check_ans3 + "\n" +radio_ans1 + "\n" +radio_ans2;

        //my logic and message

        TextView summaryText = (TextView) findViewById(R.id.summary_text);
        summaryText.setText(String.valueOf(summary));
    }
}
