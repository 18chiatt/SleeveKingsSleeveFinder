package com.sleeveking.Data;

import java.util.ArrayList;

public class Game {
    public Game(String name) {
        this.name = name;
        theSizes = new ArrayList<>();

    }

    public void addCountSize(CountAndSize toAdd){
        theSizes.add(toAdd);
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Data.Game{" +
                "name='" + name + '\'' +
                ", theSizes=" + theSizes.toString() +
                '}';
    }

    String name;

    public ArrayList<CountAndSize> getTheSizes() {
        return theSizes;
    }

    ArrayList<CountAndSize> theSizes;

}
