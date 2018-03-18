package com.bjartelarsen.lab1a;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("A1");

        // Adds event listener on spinner
        addEventListenerToSpinner();
        addEventListenerToButton();
        // Adds event listener on button
        //addListenerOnButton();
    }


    private void addEventListenerToButton() {
        Button button = findViewById(R.id.B1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText T1 = findViewById(R.id.T1);

                Intent intent = new Intent(getApplicationContext(), a2.class);
                intent.putExtra("T1", T1.getText().toString());

                startActivity(intent);
            }
        });
    }


    private void addEventListenerToSpinner() {
        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner);

        String[] items = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

        getSpinnerPref();

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                SharedPreferences sharedPref = getSharedPreferences("FileName",0);

                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("spinnerSelection", position);
                prefEditor.apply();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void getSpinnerPref() {
        Spinner spinner = findViewById(R.id.spinner);

        SharedPreferences sharedPref = getSharedPreferences("FileName",MODE_PRIVATE);
        int spinnerValue = sharedPref.getInt("spinnerSelection",-1);
        if(spinnerValue != -1) {
            spinner.setSelection(spinnerValue);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        System.exit(0);
        return true;
    }
}
