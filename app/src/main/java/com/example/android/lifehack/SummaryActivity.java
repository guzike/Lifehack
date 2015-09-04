package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    public final static String EXTRA_NAME = "name";
    public final static String EXTRA_ANS_TEXT = "ansText";
    public final static String EXTRA_ANS_CHECK1 = "ans_check1";
    public final static String EXTRA_ANS_CHECK2 = "ans_check2";
    public final static String EXTRA_ANS_CHECK3 = "ans_check3";
    public final static String EXTRA_ANS_RADIO1 = "ans_radio1";
    public final static String EXTRA_ANS_RADIO2 = "ans_radio2";

    TextView congratText = (TextView) findViewById(R.id.congrat_text);
    TextView summaryText = (TextView) findViewById(R.id.summary_text);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        createSummary();
    }

    /**
     * This method get bundle from the previous activity, calculates quantity of the right answers and displays congratulation message with score
     */
    public void createSummary(){

        int score = 0;

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String name = extras.getString(EXTRA_NAME);
        String ansText = extras.getString(EXTRA_ANS_TEXT);

        boolean check_ans1 = extras.getBoolean(EXTRA_ANS_CHECK1);
        boolean check_ans2 = extras.getBoolean(EXTRA_ANS_CHECK2);
        boolean check_ans3 = extras.getBoolean(EXTRA_ANS_CHECK3);

        boolean radio_ans1 = extras.getBoolean(EXTRA_ANS_RADIO1);
        boolean radio_ans2 = extras.getBoolean(EXTRA_ANS_RADIO2);

        if(ansText!=null) {
            if (ansText.toLowerCase().contains("times")) {
                score++;
            }
        }

        if(check_ans1 && !check_ans2 && check_ans3){
            score++;
        }

        if(radio_ans1 && !radio_ans2){
            score++;
        }

        String summary = getString(R.string.your_score) + score + "/3";

        if(name != null){
            if(name.length() > 0){
                congratText.setText(getString(R.string.congrat_name) + name + "!");
            }
        }

        summaryText.setText(String.valueOf(summary));
    }
}