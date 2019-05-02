package ch.avirtualfriend.myspots.services.Location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ch.avirtualfriend.myspots.models.Spot;

public class SpotLocationListener implements LocationListener {
    private final Spot spot;
    private final GoogleMap googleMap;

    public SpotLocationListener(Spot spot, GoogleMap googleMap) {
        this.spot = spot;
        this.googleMap = googleMap;

    }

    @Override
    public void onLocationChanged(Location location) {
        spot.setLatitude(location.getLatitude());
        spot.setLongitude(location.getLongitude());
        spot.setAltitude(location.getAltitude());

        LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(myLocation)
                .title("Ici"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
