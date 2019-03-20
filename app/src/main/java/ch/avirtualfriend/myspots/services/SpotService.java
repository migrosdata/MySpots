package ch.avirtualfriend.myspots.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import ch.avirtualfriend.myspots.models.Picture;
import ch.avirtualfriend.myspots.models.Spot;

public class SpotService implements ISpotService {
    public Collection<Spot> getAllSpots() {
        ArrayList<Spot> spots = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Picture p = new Picture();
            Spot spot = new Spot(Integer.toString(i),
                    "Best place " + 1,
                    Math.random(),
                    Math.random(),
                    new Date(),
                    "#YOLO",
                    null,
                    null);
            spots.add(spot);
        }
        return spots;
    }
/*
    private Bitmap loadRandomImage() {
        URL url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
        return BitmapFactory.decodeStream(url.openConnection().getInputStream());
    }
*/
}
