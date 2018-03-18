package com.bjartelarsen.lab1a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class a3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("A3");

        addEventListenerToButton();

    }

    private void addEventListenerToButton() {
        Button button = findViewById(R.id.B3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText t4text = findViewById(R.id.T4);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("t4text", t4text.getText().toString());

                setResult(a2.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), a2.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
