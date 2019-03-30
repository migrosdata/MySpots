package ch.avirtualfriend.myspots.services;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ch.avirtualfriend.myspots.models.Picture;
import ch.avirtualfriend.myspots.models.Spot;
import ch.avirtualfriend.myspots.models.SpotImage;

public class SpotService implements ISpotService {
    static ArrayList<Spot> spots;

    public SpotService() {
        //loadDefaultContent();
    }

    public static void loadDefaultContent() {
        if (spots != null) {
            return;
        }
        spots = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Picture p = new Picture();
            Spot spot = new Spot(Integer.toString(i),
                    "Best place " + Integer.toString(i),
                    ThreadLocalRandom.current().nextDouble(0, 91),
                    ThreadLocalRandom.current().nextDouble(0, 91),
                    new Date(),
                    "#YOLO");
            SpotImage spotImage = new SpotImage();
            loadImage(spotImage);
            spot.getImages().add(spotImage);
            spots.add(spot);
        }
    }

    private static void loadImage(SpotImage spotImage) {
        String[] themes = {"city", "nature", "cat"};
        String theme = themes[ThreadLocalRandom.current().nextInt(0, 3)];
        Log.d("DEBUG", "loadImage");
        Picasso.get()
                .load("http://lorempixel.com/640/480/" + theme + "/?a=" + Integer.toString(ThreadLocalRandom.current().nextInt()))
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .into(spotImage);
    }

    public List<Spot> getAllSpots() {
        return spots;
    }

    @Override
    public void addSpot(Spot spot) {
        spots.add(spot);
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
