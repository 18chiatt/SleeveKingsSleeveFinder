package com.sleeveking;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.sleeveking.Data.Games;
import com.sleeveking.Data.Sleeves;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Cache {
    private static Cache instance;
    public Games theGames;
    public Sleeves theSleeves;

    public static Cache getInstance(){
        if(instance == null){
            instance = new Cache();
        }
        return instance;

    }
    private Cache(){

    }


    public void getSleeves(Context c) {


        BufferedReader br = null;
        try {
            InputStream open = c.getAssets().open("Sleeves.json");
            InputStreamReader r = new InputStreamReader(open);
            br = new BufferedReader(r);
            if(br == null){
                System.out.println("Yep, it's null");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        theSleeves = new Gson().fromJson(br,Sleeves.class);
        Log.i( "App", "Added " + theSleeves.data.size() + " Sleeve types");

        return;

    }

    public void getGames(Context c) {
        BufferedReader br = null;
        try {
            InputStream open = c.getAssets().open("Games.json");

            InputStreamReader r = new InputStreamReader(open);
            br = new BufferedReader(r);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        theGames = new Gson().fromJson(br,Games.class);

        Log.i( "App", "Added " + theGames.data.size() + " Games");

    }


}
