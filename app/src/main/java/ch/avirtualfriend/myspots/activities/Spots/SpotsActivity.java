package ch.avirtualfriend.myspots.activities.Spots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import ch.avirtualfriend.myspots.R;

public class SpotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        TextView textViewInt = (TextView)findViewById(R.id.textViewInt);
        Bundle b = getIntent().getExtras();
        if(b != null) {
            String spotId = Integer.toString(b.getInt("key"));
            textViewInt.setText(spotId);
            Log.d(null, spotId);
        }
    }
}
