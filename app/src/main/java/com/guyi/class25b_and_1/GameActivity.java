package com.guyi.class25b_and_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.guyi.class25b_and_1.databinding.ActivityGameBinding;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;

    private GamaManager gamaManager;
    private AppCompatImageView[] hearts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Glide
                .with(this)
                .load(R.drawable.img_back)
                .into(binding.imgBackground);

        hearts = new AppCompatImageView[] {
                binding.imgHeart1,
                binding.imgHeart2,
                binding.imgHeart3,
        };

        gamaManager = new GamaManager();



        updateCountryUI(gamaManager.getCurrentCountry());

        binding.btnNo.setOnClickListener(v -> answer(false));
        binding.btnYes.setOnClickListener(v -> answer(true));


    }

    private void answer(boolean answer) {
        gamaManager.answered(answer);
        if (gamaManager.isGameOver()) {
            gameOver();
        } else {
            updateCountryUI(gamaManager.getCurrentCountry());
        }
        binding.lblScore.setText("" + gamaManager.getScore());
        updateHearts();
    }

    private void updateHearts() {
        for (int i = 0; i < hearts.length; i++) {
            if (i < gamaManager.getLives()) {
                hearts[i].setVisibility(View.VISIBLE);
            } else {
                hearts[i].setVisibility(View.INVISIBLE);
            }
        }
    }

    private void updateCountryUI(Country country) {
        binding.lblName.setText(country.getName());
        binding.imgFlag.setImageResource(country.getImage());
    }

    private void gameOver() {
        binding.btnNo.setEnabled(false);
        binding.btnYes.setEnabled(false);
        binding.lblName.setText("Game Over");
        binding.imgFlag.setImageResource(0);
        Toast.makeText(this, "Game Over\nScore: " + gamaManager.getScore(), Toast.LENGTH_SHORT).show();
        //finish();
    }
}