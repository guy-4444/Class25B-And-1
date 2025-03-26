package com.guyi.class25b_and_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_clickMe);
        TextView lbl = findViewById(R.id.lbl_title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lbl.setText("" + num);
                num *= 2;
            }
        });



    }
}