package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000; //Duration of wait

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);


        //New Handler to start the NameActivity
        //and close this Splash-Screen after some seconds.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Create an Intent that will start the NameActivity.
                Intent mainIntent = new Intent(SplashActivity.this, NameActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}