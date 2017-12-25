package com.example.abhishek.odiscorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String teama,teamb,overs,wkts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        EditText t1 = (EditText) findViewById(R.id.teama);
        EditText t2 = (EditText) findViewById(R.id.teamb);
        EditText over = (EditText) findViewById(R.id.overs);
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
