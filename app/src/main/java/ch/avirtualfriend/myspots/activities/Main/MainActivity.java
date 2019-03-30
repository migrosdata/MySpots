package ch.avirtualfriend.myspots.activities.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.avirtualfriend.myspots.R;
import ch.avirtualfriend.myspots.activities.Spots.SpotsActivity;
import ch.avirtualfriend.myspots.models.Spot;
import ch.avirtualfriend.myspots.models.SpotImage;
import ch.avirtualfriend.myspots.services.ISpotService;
import ch.avirtualfriend.myspots.services.SpotService;

public class MainActivity extends AppCompatActivity {
    List<String> spotNames = new ArrayList<>();
    private static final SpotImage spotImage = new SpotImage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.view_spots);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        SpotAdapter spotAdapter = new SpotAdapter(new SpotService().getAllSpots());
        rv.setAdapter(spotAdapter);
        Picasso.get().setLoggingEnabled(true);
        Button buttonAdd = (Button)findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpotsActivity.class);
                Bundle b = new Bundle();
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();
            }
        });
    }
}
