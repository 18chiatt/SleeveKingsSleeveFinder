package com.sleeveking.GameActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sleeveking.Cache;
import com.sleeveking.Data.CountAndSize;
import com.sleeveking.Data.Sleeve;
import com.sleeveking.MainActivity.RecyclerViewAdapter;
import com.sleeveking.R;

import java.util.ArrayList;

public class SleevesViewAdapter extends RecyclerView.Adapter<SleevesViewAdapter.ViewHolderSleeve> {

    public SleevesViewAdapter(Context context, ArrayList<CountAndSize> toDisplay) {
        this.context = context;
        this.toDisplay = toDisplay;
    }

    private Context context;
    private ArrayList<CountAndSize> toDisplay;



    @NonNull
    @Override
    public ViewHolderSleeve onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sleeve_recycler,parent,false);
        ViewHolderSleeve holder = new ViewHolderSleeve(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSleeve holder, int position) {
        Sleeve theSleeve = Cache.getInstance().theSleeves.data.get(toDisplay.get(position).getSize());

        holder.sleeveText.setText(toDisplay.get(position).getSize());

        holder.countText.setText(toDisplay.get(position).getCount());

        if(theSleeve == null){
            holder.widthText.setText("?");
            holder.heightText.setText("?");
            holder.SKU.setText("?");
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String toDisplay = context.getResources().getString(R.string.unableToFindMatchingSize);
                    Toast.makeText(context,toDisplay,Toast.LENGTH_LONG).show();
                }
            });

        } else {
            holder.sleeveText.setPaintFlags(holder.sleeveText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            holder.sleeveText.setTextColor(context.getResources().getColor(R.color.linkColor));
            holder.widthText.setText(theSleeve.getWidth());
            holder.heightText.setText(theSleeve.getHeight());
            holder.SKU.setText(theSleeve.getSKU());
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(theSleeve.getLink()));
                    context.startActivity(browserIntent);

                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return toDisplay.size();
    }

    public class ViewHolderSleeve extends RecyclerView.ViewHolder {
        TextView sleeveText;
        TextView widthText;
        TextView countText;
        TextView heightText;
        ConstraintLayout constraintLayout;
        TextView SKU;


        public ViewHolderSleeve(@NonNull View itemView) {
            super(itemView);

            sleeveText = itemView.findViewById(R.id.SleeveNameDisplay);
            widthText = itemView.findViewById(R.id.width);
            countText = itemView.findViewById(R.id.cardCountDisplay);
            heightText = itemView.findViewById(R.id.height);
            constraintLayout = itemView.findViewById(R.id.SleeveLayout);
            SKU = itemView.findViewById(R.id.SKU);
        }
    }

}
