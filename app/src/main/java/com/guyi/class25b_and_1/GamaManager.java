package com.guyi.class25b_and_1;

import android.widget.Toast;

import java.util.ArrayList;

public class GamaManager {


    private ArrayList<Country> countries;
    private int currentCountryIndex = 0;
    private int score = 0;
    private int lives = 3;

    public GamaManager() {
        countries = getCountries();
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    private void next() {
        currentCountryIndex++;
    }

    public boolean isGameOver() {
        return currentCountryIndex >= countries.size()  ||  lives <= 0;
    }

    public Country getCurrentCountry() {
        return countries.get(currentCountryIndex);
    }

    public boolean answered(boolean answer) {
        boolean isCorrect = getCurrentCountry().isIsland() == answer;
        score += isCorrect ? 1 : 0;
        lives -= isCorrect ? 0 : 1;
        next();
        return isCorrect;
    }

    private static ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country().setName("Chile").setImage(R.drawable.img_cl).setIsland(false));
        countries.add(new Country().setName("Greenland").setImage(R.drawable.img_gl).setIsland(true));
        countries.add(new Country().setName("Israel").setImage(R.drawable.img_il).setIsland(false));
        countries.add(new Country().setName("Kiribati").setImage(R.drawable.img_ki).setIsland(true));
        countries.add(new Country().setName("Morocco").setImage(R.drawable.img_ma).setIsland(false));
        countries.add(new Country().setName("Mongolia").setImage(R.drawable.img_mn).setIsland(false));
        countries.add(new Country().setName("Palau").setImage(R.drawable.img_pw).setIsland(true));
        countries.add(new Country().setName("Sweden").setImage(R.drawable.img_se).setIsland(false));
        countries.add(new Country().setName("Thailand").setImage(R.drawable.img_th).setIsland(false));
        countries.add(new Country().setName("USA").setImage(R.drawable.img_us).setIsland(false));
        countries.add(new Country().setName("Japan").setImage(R.drawable.img_jp).setIsland(true));

        return countries;
    }

}
