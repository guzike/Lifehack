package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class QuizActivity extends AppCompatActivity {

    public final static String EXTRA_ANS_TEXT = "ansText";
    public final static String EXTRA_ANS_CHECK1 = "ans_check1";
    public final static String EXTRA_ANS_CHECK2 = "ans_check2";
    public final static String EXTRA_ANS_CHECK3 = "ans_check3";
    public final static String EXTRA_ANS_RADIO1 = "ans_radio1";
    public final static String EXTRA_ANS_RADIO2 = "ans_radio2";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    /**
     * This method gets bundle from the previous activity, saves information entered in this QuizActivity and changes to the next activity
     * @param view the button clicked by the user
     */
    public void sbContToSum(View view){

        Intent toSum = new Intent(this, SummaryActivity.class);
        Bundle extras = getIntent().getExtras();

        extras.putBoolean(EXTRA_ANS_CHECK1, check_ans1);
        extras.putBoolean(EXTRA_ANS_CHECK2, check_ans2);
        extras.putBoolean(EXTRA_ANS_CHECK3, check_ans3);

        extras.putBoolean(EXTRA_ANS_RADIO1, radio_ans1);
        extras.putBoolean(EXTRA_ANS_RADIO2, radio_ans2);

        extras.putCharSequence(EXTRA_ANS_TEXT, ansText);

        toSum.putExtras(extras);
        startActivity(toSum);
    }
}