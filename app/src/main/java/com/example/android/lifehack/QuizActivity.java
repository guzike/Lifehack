package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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

    /**
     * This method gets bundle from the previous activity, saves information entered in this QuizActivity and changes to the next activity
     * @param view object
     */
    public void sbContToSum(View view){

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.check_ans1);
        boolean check_ans1 = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.check_ans2);
        boolean check_ans2 = checkBox2.isChecked();

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.check_ans3);
        boolean check_ans3 = checkBox3.isChecked();

        RadioButton radioButton1 = (RadioButton) findViewById(R.id.yes_radio_button);
        boolean radio_ans1 = radioButton1.isChecked();

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.no_radio_button);
        boolean radio_ans2 = radioButton2.isChecked();

        EditText textField = (EditText) findViewById(R.id.answer1_view);
        String ansText = textField.getText().toString();

        Intent toSum = new Intent(this, SummaryActivity.class);
        Bundle extras = getIntent().getExtras();

        extras.putBoolean("check_ans1", check_ans1);
        extras.putBoolean("check_ans2", check_ans2);
        extras.putBoolean("check_ans3", check_ans3);

        extras.putBoolean("radio_ans1", radio_ans1);
        extras.putBoolean("radio_ans2", radio_ans2);

        extras.putCharSequence("ansText", ansText);


        toSum.putExtras(extras);
        startActivity(toSum);
    }


}
