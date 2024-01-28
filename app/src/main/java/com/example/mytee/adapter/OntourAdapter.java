package com.example.mytee.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytee.EventActivity;
import com.example.mytee.R;
import com.example.mytee.model.OntourData;

import java.util.List;


public class OntourAdapter extends RecyclerView.Adapter<OntourAdapter.OntourViewHolder> {

    Context context;
    List<OntourData> ontourDataList;

    public OntourAdapter(Context context, List<OntourData> ontourDataList) {
        this.context = context;
        this.ontourDataList = ontourDataList;
    }

    @NonNull
    public OntourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.ontour_row_item, parent, false);
        return new OntourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OntourViewHolder holder, int position) {
        holder.imageTour.setImageResource(ontourDataList.get(position).getImagetour());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, EventActivity.class);
                context.startActivity(i);
            }
        });
    }

    

    public int getItemCount() {
        return ontourDataList.size();
    }

    public static final class OntourViewHolder extends RecyclerView.ViewHolder{

        ImageView imageTour;

        public OntourViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTour = itemView.findViewById(R.id.imagetour);

        }
    }
}
