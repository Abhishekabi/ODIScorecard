package com.example.abhishek.odiscorecard;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String teama,teamb,overs,wkts;
    private String[] wktSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wktSpinner = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
        Spinner spinner = (Spinner)findViewById(R.id.wkts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,wktSpinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                tv.setTextColor(Color.WHITE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        wkts = spinner.getSelectedItem().toString();

        Button button = (Button)findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_fieldStatus()){
                    Intent intent = new Intent(MainActivity.this,NextPage.class);
                    startActivity(intent);
                }else{
                    Toast toast = Toast.makeText(MainActivity.this,"Fields Cannot be left empty!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }

    private boolean check_fieldStatus() {
        EditText t1 =  findViewById(R.id.teama);
        EditText t2 =  findViewById(R.id.teamb);
        EditText over =  findViewById(R.id.overs);
        teama = t1.getText().toString();
        teamb = t2.getText().toString();
        overs = over.getText().toString();
        if(teama.isEmpty()||teamb.isEmpty()||overs.isEmpty())
        {
            return false;
        }
        return true;
    }


}
