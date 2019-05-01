package ch.avirtualfriend.myspots.services.Location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import ch.avirtualfriend.myspots.models.Spot;


public class SpotLocationListener extends Activity implements LocationListener {
    private Spot spot;
    private Location location;
    private LocationManager locationManager;

    public SpotLocationListener() throws SecurityException{
        location = new Location(LocationManager.GPS_PROVIDER);
        locationManager = (LocationManager)
               getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 10, this);
    }

    public SpotLocationListener(Spot spot) {
        this();
        this.spot = spot;
    }

    @Override
    public void onLocationChanged(Location location) {
        //spot.setLatitude(location.getLatitude());
        //spot.setLongitude(location.getLongitude());
        //spot.setAltitude(location.getAltitude());
        this.location = location;
    }

    public Location getLocation(){
        return this.location;
    }

    public void setSpotLocation(Location location){
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
