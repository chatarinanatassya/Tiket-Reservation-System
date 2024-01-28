package com.example.mytee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytee.R;
import com.example.mytee.model.EventData;
import com.example.mytee.model.OntourData;

import java.util.List;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    Context context;
    List<EventData> eventDataList;

    public EventAdapter(Context context, List<EventData> eventDataList) {
        this.context = context;
        this.eventDataList = eventDataList;
    }

    @NonNull
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.event_row_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

        holder.country.setText(eventDataList.get(position).getCountry());
        holder.eventName.setText(eventDataList.get(position).getEventname());
        holder.price.setText(eventDataList.get(position).getPrice());
        holder.imageTour.setImageResource(eventDataList.get(position).getImagetour());
    }



    public int getItemCount() {
        return eventDataList.size();
    }

    public static final class EventViewHolder extends RecyclerView.ViewHolder{

        ImageView imageTour;
        TextView eventName, country, price;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTour = itemView.findViewById(R.id.imagetour);
            eventName = itemView.findViewById(R.id.eventname);
            country = itemView.findViewById(R.id.country);
            price = itemView.findViewById(R.id.price);
        }
    }
}
