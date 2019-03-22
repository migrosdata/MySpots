package ch.avirtualfriend.myspots.services;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import ch.avirtualfriend.myspots.models.Picture;
import ch.avirtualfriend.myspots.models.Spot;
import ch.avirtualfriend.myspots.models.SpotImage;

public class SpotService implements ISpotService {
    ArrayList<Spot> spots;

    public SpotService() {
        loadDefaultContent();
    }

    private void loadDefaultContent() {
        spots = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Picture p = new Picture();
            Spot spot = new Spot(Integer.toString(i),
                    "Best place " + Integer.toString(i),
                    Math.random(),
                    Math.random(),
                    new Date(),
                    "#YOLO");
            SpotImage spotImage = new SpotImage();
            loadImage(spotImage);
            spot.getImages().add(spotImage);
            spots.add(spot);
        }
    }

    private void loadImage(SpotImage spotImage) {
        Picasso.get().load("http://lorempixel.com/640/480/nature/").into(spotImage);
    }

    public Collection<Spot> getAllSpots() {
        return spots;
    }

    public Spot getSpotById(String id) {
        for (Spot spot : spots) {
            if (spot.getId().equals(id)) {
                return spot;
            }
        }
        return null;
    }
/*
    private Bitmap loadRandomImage() {
        URL url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
        return BitmapFactory.decodeStream(url.openConnection().getInputStream());
    }
*/
}
