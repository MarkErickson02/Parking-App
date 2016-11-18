package com.example.gener_000.parkingproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button go_to_maps = (Button) findViewById(R.id.go_to_map);
        go_to_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Google_Maps_Page.class));
            }
        });
        Button go_to_graph = (Button) findViewById(R.id.go_to_graph_from_report);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner parkingLotSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.parking_lots,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkingLotSpinner.setAdapter(adapter);
        parkingLotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.emptyRadioButton:
                if (checked){

                }
                break;
            case R.id.mostlyEmptyRadioButton:
                if (checked){

                }
                break;
            case R.id.mostlyFullRadioButton:
                if (checked){

                }
                break;
            case R.id.fullRadioButton:
                if (checked){

                }
                break;
        }
    }


    public void sendMessage(View view){

    }


}

