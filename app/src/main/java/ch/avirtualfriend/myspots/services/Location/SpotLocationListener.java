package ch.avirtualfriend.myspots.services.Location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import ch.avirtualfriend.myspots.models.Spot;

public class SpotLocationListener implements LocationListener {
    private final Spot spot;

    public SpotLocationListener(Spot spot) {
        this.spot = spot;
    }

    @Override
    public void onLocationChanged(Location location) {
        spot.setLatitude(location.getLatitude());
        spot.setLongitude(location.getLongitude());
        spot.setAltitude(location.getAltitude());
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
