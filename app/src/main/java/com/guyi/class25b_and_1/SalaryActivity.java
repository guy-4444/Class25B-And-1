package com.guyi.class25b_and_1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;


public class SalaryActivity extends AppCompatActivity {

    private MaterialTextView lbl_result;
    private MaterialButton btn_calculate;
    private EditText edt_gross;

    private final static double MAX_GROSS_FOR_EDUCATION_FUND = 15712.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary);


        lbl_result = findViewById(R.id.lbl_result);
        btn_calculate = findViewById(R.id.btn_calculate);
        edt_gross = findViewById(R.id.edt_gross);


        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateClicked();
            }
        });


    }

    private void calculateClicked() {
        String input = edt_gross.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double gross = Double.valueOf(input);
        if (gross < 0) {
            Toast.makeText(this, "Please enter a positive value", Toast.LENGTH_SHORT).show();
            return;
        }


        double educationFund = Math.min(gross, MAX_GROSS_FOR_EDUCATION_FUND) * 0.025;

        lbl_result.setText("" + educationFund);
        hideKeyboard();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edt_gross.getWindowToken(), 0);
    }

}