package ch.avirtualfriend.myspots.activities.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.avirtualfriend.myspots.R;
import ch.avirtualfriend.myspots.activities.Spots.SpotsActivity;
import ch.avirtualfriend.myspots.models.Spot;
import ch.avirtualfriend.myspots.services.ISpotService;
import ch.avirtualfriend.myspots.services.SpotService;

public class MainActivity extends AppCompatActivity {
    List<String> spotNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListViewSpots();
        addListener();
    }

    private void loadListViewSpots() {
        ListView listViewSpots = (ListView) findViewById(R.id.listViewSpots);
        ISpotService spotService = new SpotService();
        Collection<Spot> spots = spotService.getAllSpots();
        for (Spot spot : spots) {
            spotNames.add(spot.getName());
        }
        ArrayAdapter<String> spotsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spotNames);
        listViewSpots.setAdapter(spotsAdapter);
    }

    private void addListener() {
        ListView listViewSpots = (ListView) findViewById(R.id.listViewSpots);
        listViewSpots.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SpotsActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", position); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();
            }
        });
    }
}
