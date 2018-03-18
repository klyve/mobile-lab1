package com.bjartelarsen.lab1a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class a2 extends AppCompatActivity {


    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("A2");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            final String value = bundle.getString("T1");
            TextView t2 = findViewById(R.id.T2);
            String output = "Hello " + value;
            t2.setText(output);
        }

        addEventListenerToButton();

    }

    private void addEventListenerToButton() {
        Button button = findViewById(R.id.B2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), a3.class);
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("t4text");
                TextView t3 = findViewById(R.id.T3);
                String output = "From A3: " + result;
                t3.setText(output);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
