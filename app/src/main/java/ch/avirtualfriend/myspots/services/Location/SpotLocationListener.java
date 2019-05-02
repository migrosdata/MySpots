package ch.avirtualfriend.myspots.services.Location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.zip.ZipOutputStream;

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
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17));
      /*  googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {


            @Override
            public void onCameraIdle() {
                float zoomLevel = googleMap.getCameraPosition().zoom;
                String zoom = String.valueOf(zoomLevel);
                Log.d("DEBBUG", zoom);
            }
        });*/

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
