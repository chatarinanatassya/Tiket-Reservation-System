package com.example.mytee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mytee.adapter.EventAdapter;
import com.example.mytee.adapter.OntourAdapter;
import com.example.mytee.model.EventData;
import com.example.mytee.model.OntourData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    RecyclerView ontourRecycler, eventRecycler;
    OntourAdapter ontourAdapter;
    EventAdapter eventAdapter;


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Now here we will add some dummy data in our model class

        List<OntourData> ontourDataList = new ArrayList<>();
        ontourDataList.add(new OntourData("Frank Ocean Channel ORANGE Tour","New York","From $200",R.drawable.ontour3));
        ontourDataList.add(new OntourData("Harry Styles Love On Tour","Singapore","From $300",R.drawable.ontour1));
        ontourDataList.add(new OntourData("The Dream Show 2","Jakarta","From $200",R.drawable.ontour2));
        ontourDataList.add(new OntourData("John Mayer Asia Tour","Malaysia","From $300",R.drawable.ontour6));
        ontourDataList.add(new OntourData("NCT 127 The Unity","Jakarta","From $200",R.drawable.ontour4));
        ontourDataList.add(new OntourData("Ariana Grande Tour","Jakarta","From $300",R.drawable.ontour5));

        setRecentRecycler(ontourDataList);

        List<EventData> eventDataList = new ArrayList<>();
        eventDataList.add(new EventData("Red Velvet : R to V 2023", "Jakarta","From $200",R.drawable.ontour8));
        eventDataList.add(new EventData("Taeyon : The ODD Of LOVE", "Jakarta","From $200",R.drawable.ontour7));
        eventDataList.add(new EventData("Isyana Sarasvati Fan Meeting", "Surabaya","From $200",R.drawable.ontour9));
        eventDataList.add(new EventData("WayV : Phantom Fan Meeting", "Jakarta","From $200",R.drawable.ontour0));

        setEventRecycler(eventDataList);
    }

    private  void setRecentRecycler(List<OntourData> ontourDataList){

        ontourRecycler = findViewById(R.id.ontour_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        ontourRecycler.setLayoutManager(layoutManager);
        ontourAdapter = new OntourAdapter(this, ontourDataList);
        ontourRecycler.setAdapter(ontourAdapter);

    }

    private  void setEventRecycler(List<EventData> eventDataList){

        eventRecycler = findViewById(R.id.eventRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        eventRecycler.setLayoutManager(layoutManager);
        eventAdapter = new EventAdapter(this, eventDataList);
        eventRecycler.setAdapter(eventAdapter);

    }


}
