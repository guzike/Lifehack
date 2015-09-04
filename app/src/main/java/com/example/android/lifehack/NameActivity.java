package com.example.android.lifehack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    public final static String EXTRA_NAME = "name";

    EditText mNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mNameField = (EditText) findViewById(R.id.name_view);
    }

    /**
     * This method saves name entered and changes the activity.
     * @param view the button clicked by the user
     */
    public void sbContToMain(View view){

        Intent intent = new Intent(this, MainActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NAME, getName());

        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(EXTRA_NAME,getName());
    }

    /**
     * This method gets the name that is entered to the EditText with id = name_view
     * @return String name entered
     */
    public String getName(){

        return mNameField.getText().toString();
    }
}