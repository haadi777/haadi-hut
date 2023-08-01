package com.example.bodymasscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText editFt, editInch, editWt;
        Button btnResult;
        LinearLayout LMain;

        editFt=findViewById(R.id.ft);
        editInch=findViewById(R.id.inch);
        editWt=findViewById(R.id.weight);
        btnResult=findViewById(R.id.btn);
        txtResult=findViewById(R.id.result);
        LMain=findViewById(R.id.LMain);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt = Integer.parseInt(editWt.getText().toString());
               int ft = Integer.parseInt(editFt.getText().toString());
               int inch = Integer.parseInt(editInch.getText().toString());

               int totalInch = ft*12 + inch;

               double totalCm=totalInch*2.53;

               double totalM=totalCm/100;

               double bmi = wt/(totalM*totalM);

               if (bmi >25){
                   txtResult.setText("You Are Overweight!");
                   LMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
               } else if (bmi<18) {
                   txtResult.setText("You Are Underweight!");
                   LMain.setBackgroundColor(getResources().getColor(R.color.colorUW));

               }
               else {
                   txtResult.setText("You Are Healthy!");
                   LMain.setBackgroundColor(getResources().getColor(R.color.colorH));
               }

            }
        });

    }


}