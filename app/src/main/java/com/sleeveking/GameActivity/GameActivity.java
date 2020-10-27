package com.sleeveking.GameActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sleeveking.Cache;
import com.sleeveking.Data.Game;
import com.sleeveking.R;

public class GameActivity extends AppCompatActivity {
    public static String PUT_GAME_NAME_HERE = "GAME_KEY";
    TextView gameDisplay;
    RecyclerView recyclerView;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameDisplay = findViewById(R.id.gameName);
        recyclerView = findViewById(R.id.SleeveDisplayRecycler);
        button = findViewById(R.id.imageButton);

        Intent intent = this.getIntent();
        Bundle extras = intent.getExtras();
        String gameName = extras.getString(PUT_GAME_NAME_HERE);
        gameDisplay.setText(gameName);
        Game toDisplay = Cache.getInstance().theGames.data.get(gameName);

        SleevesViewAdapter adapter = new SleevesViewAdapter(this,toDisplay.getTheSizes());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener((c)-> {
            finish();
        });





    }
}