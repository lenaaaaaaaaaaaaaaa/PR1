package ru.mirea.recyclerviewapp_hw;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<HistoricalEvent> countries = getListData();
        RecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new HistoricalEventRecyclerViewAdapter(countries));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<HistoricalEvent> getListData() {
        List<HistoricalEvent> list = new ArrayList<>();
        list.add(new HistoricalEvent("World War II",
                "A global war that lasted from 1939 to 1945.",
                R.drawable.world_war2));
        list.add(new HistoricalEvent("Moon Landing",
                "First manned moon landing by Apollo 11 in 1969.",
                R.drawable.moon_landing));
        list.add(new HistoricalEvent("Fall of the Berlin Wall",
                "Symbolized the end of the Cold War in 1989.",
                R.drawable.berlin_wall));
        list.add(new HistoricalEvent("American Revolution",
                "A revolution that led to the independence of the USA in 1776.",
                R.drawable.american_revolution));
        list.add(new HistoricalEvent("Industrial Revolution",
                "A period of major industrialization during the 18th century.",
                R.drawable.industrial_revolution));
        list.add(new HistoricalEvent("French Revolution",
                "A period of social and political upheaval in France in 1789.",
                R.drawable.french_revolution));
        return list;
    }
}