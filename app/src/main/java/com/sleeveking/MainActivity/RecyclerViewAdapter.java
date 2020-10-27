package com.sleeveking.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sleeveking.GameActivity.GameActivity;
import com.sleeveking.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public RecyclerViewAdapter(ArrayList<String> gameNames, Context currContext) {
        this.gameNames = gameNames;
        this.currContext = currContext;
    }

    public void updateItems(ArrayList<String> toDisplay){
        this.gameNames = toDisplay;

    }

    private ArrayList<String> gameNames = new ArrayList<>();
    private Context currContext;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.view.setText(gameNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = v.findViewById(R.id.textView).toString();

                Intent intent = new Intent(currContext,GameActivity.class);
                intent.putExtra(GameActivity.PUT_GAME_NAME_HERE,holder.view.getText());

                currContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return gameNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView view;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.textView);
            parentLayout = itemView.findViewById(R.id.ConstraintRecycler);
        }
    }
}
