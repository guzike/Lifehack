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

    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;

    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;

    EditText mTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mCheckBox1 = (CheckBox) findViewById(R.id.check_ans1);
        mCheckBox2 = (CheckBox) findViewById(R.id.check_ans2);
        mCheckBox3 = (CheckBox) findViewById(R.id.check_ans3);

        mRadioButton1 = (RadioButton) findViewById(R.id.yes_radio_button);
        mRadioButton2 = (RadioButton) findViewById(R.id.no_radio_button);

        mTextField = (EditText) findViewById(R.id.answer1_view);
    }

    /**
     * This method gets bundle from the previous activity, saves information entered in this QuizActivity and changes to the next activity
     * @param view the button clicked by the user
     */
    public void sbContToSum(View view){

        boolean check_ans1 = mCheckBox1.isChecked();
        boolean check_ans2 = mCheckBox2.isChecked();
        boolean check_ans3 = mCheckBox3.isChecked();

        boolean radio_ans1 = mRadioButton1.isChecked();
        boolean radio_ans2 = mRadioButton2.isChecked();

        String ansText = mTextField.getText().toString();

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