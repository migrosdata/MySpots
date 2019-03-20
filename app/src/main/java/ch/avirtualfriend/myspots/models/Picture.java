package ch.avirtualfriend.myspots.models;

import android.media.Image;

public class Picture {
    private String id;
    private Image content;
    private Spot spot;

    public String getId() {
        return id;
    }

    public Image getContent() {
        return content;
    }

    public void setContent(Image content) {
        this.content = content;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
