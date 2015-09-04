package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method gets bundle from the previous activity and changes to the next activity
     * @param view object
     */
    public void sbContToQuiz(View view){

        Intent toQuiz = new Intent(this, QuizActivity.class);
        toQuiz.putExtras(getIntent().getExtras());
        startActivity(toQuiz);
    }
}
