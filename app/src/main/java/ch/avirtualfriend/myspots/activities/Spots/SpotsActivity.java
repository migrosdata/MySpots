package ch.avirtualfriend.myspots.activities.Spots;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.concurrent.ThreadLocalRandom;

import ch.avirtualfriend.myspots.R;
import ch.avirtualfriend.myspots.activities.Main.MainActivity;
import ch.avirtualfriend.myspots.models.Spot;
import ch.avirtualfriend.myspots.persistence.SpotDataSource;
import ch.avirtualfriend.myspots.services.Location.SpotLocationListener;
import ch.avirtualfriend.myspots.services.SpotService;

public class SpotsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Spot currentSpot;
    private GoogleMap gmap;
    private SpotDataSource spotDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);
        spotDataSource = new SpotDataSource(this);
        Button buttonAdd = (Button) findViewById(R.id.button_add);
        //addNewSpot();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long rowId = spotDataSource.insertSpot(currentSpot);
                //goToMain();
            }
        });
        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });


        TextView textViewInt = (TextView) findViewById(R.id.textViewInt);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            String spotId = Integer.toString(b.getInt("key"));
            textViewInt.setText(spotId);
            Log.d(null, spotId);
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void requestLocationPermition() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            new AlertDialog.Builder(this)
                    .setTitle("yo")
                    .setMessage("ba")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Prompt the user once explanation has been shown
                            ActivityCompat.requestPermissions(SpotsActivity.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    99);
                        }
                    })
                    .create()
                    .show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    99);
        }
        //locationManager.requestLocationUpdates(
        //        LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        currentSpot = new Spot();
        SpotLocationListener locationListener = new SpotLocationListener(currentSpot,gmap);
        switch (requestCode) {
            case 99: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:
                        //locationManager.requestLocationUpdates(provider, 400, 1, this);
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
                        currentSpot.setName("yo" +  Long.toString(ThreadLocalRandom.current().nextLong()));
                        SpotService spotService = new SpotService();
                        spotService.addSpot(currentSpot);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }
        }

    }
    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
                        "use this app")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });
        dialog.show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.gmap = googleMap;
        requestLocationPermition();
    }

    private void goToMain() {
        Intent intent = new Intent(SpotsActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
        finish();
    }
}
