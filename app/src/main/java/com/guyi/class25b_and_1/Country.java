package com.guyi.class25b_and_1;

public class Country {

    private String name;
    private int image;
    private boolean isIsland;

    public Country() {
    }

    public Country(String name, int image, boolean isIsland) {
        this.name = name;
        this.image = image;
        this.isIsland = isIsland;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public int getImage() {
        return image;
    }

    public Country setImage(int image) {
        this.image = image;
        return this;
    }

    public boolean isIsland() {
        return isIsland;
    }

    public Country setIsland(boolean island) {
        isIsland = island;
        return this;
    }
}
