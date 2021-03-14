package com.example.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    String calculateBMI(String weight, String height) {
        resultTitle.setVisibility(View.INVISIBLE);
        try {
            resultTitle.setVisibility(View.VISIBLE);
            double result = Double.parseDouble(weight) / Math.pow(Double.parseDouble(height) / 100, 2.0);
            return String.valueOf((int) result);
        } catch (Exception e) {
            resultTitle.setVisibility(View.INVISIBLE);
            return getString(R.string.warning);
        }
    }

    TextView resultTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result = findViewById(R.id.result);
        Button button = findViewById(R.id.button);
        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);
        resultTitle = findViewById(R.id.resultTitle);

        button.setOnClickListener(v -> {
            String resultText = calculateBMI(weight.getText().toString(), height.getText().toString());
            result.setText(resultText);
        });
    }
}