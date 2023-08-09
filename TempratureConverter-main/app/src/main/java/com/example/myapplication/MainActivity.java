package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText temp , ans ;
    Button convert;
    RadioButton f ,c ;
    Double x ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = findViewById(R.id.temp);
        ans = findViewById(R.id.ans);
        convert = findViewById(R.id.button);
        f = findViewById(R.id.f);
        c = findViewById(R.id.c);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp.getText().toString().isEmpty()){
                    ans.setText(" Please provide input ");
                }
                else {
                    x = Double.parseDouble(String.valueOf(temp.getText()));
                    if (c.isChecked()) {
                        x = (x * 9) / 5 + 32;
                        ans.setText(String.valueOf(x)+" °F ");
                        temp.setText(temp.getText().toString()+" °C ");
                    } else if (f.isChecked()){
                        x = (x - 32) * 5 / 9;
                        ans.setText(String.valueOf(x)+" °C ");
                        temp.setText(temp.getText().toString()+" °F ");
                    }
                    else {
                        ans.setText("Please select an option");
                    }
                }
            }
        });

    }
}