package com.sleeveking.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.sleeveking.Cache;
import com.sleeveking.Credits;
import com.sleeveking.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    RecyclerViewAdapter adapter;
    Button infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cache instance = Cache.getInstance();
        Context ctx = getApplicationContext();
        searchView = findViewById(R.id.searchView);
        infoButton = findViewById(R.id.infoButton);

        infoButton.setOnClickListener((c)-> {
            Intent intent = new Intent(this, Credits.class);
            startActivity(intent);

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Cache instance = Cache.getInstance();

                ArrayList<String> toUpdateWith =  new ArrayList<>();

                for(String s : instance.theGames.data.keySet()){
                    if(s.toLowerCase().contains(newText.toLowerCase())){
                        toUpdateWith.add(s);
                    }

                }

                adapter.updateItems(toUpdateWith);
                adapter.notifyDataSetChanged();


                return true;
            }
        });


        instance.getGames(ctx);
        instance.getSleeves(ctx);

        recyclerView = findViewById(R.id.recycler);
        ArrayList<String> arrayToShow = new ArrayList<>();
        arrayToShow.addAll(instance.theGames.data.keySet());
        adapter = new RecyclerViewAdapter(arrayToShow,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }




}