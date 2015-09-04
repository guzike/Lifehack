package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    TextView mCongratText;
    TextView mSummaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        mCongratText = (TextView) findViewById(R.id.congrat_text);
        mSummaryText = (TextView) findViewById(R.id.summary_text);

        createSummary();
    }

    /**
     * This method get bundle from the previous activity, calculates quantity of the right answers and displays congratulation message with score
     */
    public void createSummary(){

        int score = 0;

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        String name = extras.getString(NameActivity.EXTRA_NAME);
        String ansText = extras.getString(QuizActivity.EXTRA_ANS_TEXT);

        boolean check_ans1 = extras.getBoolean(QuizActivity.EXTRA_ANS_CHECK1);
        boolean check_ans2 = extras.getBoolean(QuizActivity.EXTRA_ANS_CHECK2);
        boolean check_ans3 = extras.getBoolean(QuizActivity.EXTRA_ANS_CHECK3);

        boolean radio_ans1 = extras.getBoolean(QuizActivity.EXTRA_ANS_RADIO1);
        boolean radio_ans2 = extras.getBoolean(QuizActivity.EXTRA_ANS_RADIO2);

        if (ansText!=null) {
            if (ansText.toLowerCase().contains("times")) {
                score += 2;
            }
        }

        if (check_ans1 && !check_ans2 && check_ans3) {
            score += 2;
        } else if ((check_ans1 && !check_ans2) ||
                   (!check_ans2 && check_ans3)) {
            score++;
        }

        if (radio_ans1 && !radio_ans2) {
            score++;
        }

        String summary = getString(R.string.your_score) + score + "/5";

        if (name != null) {
            if (name.length() > 0) {
                mCongratText.setText(getString(R.string.congrat_name) + name + "!");
            }
        }

        mSummaryText.setText(String.valueOf(summary));
    }
}