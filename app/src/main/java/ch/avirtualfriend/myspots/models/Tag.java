package ch.avirtualfriend.myspots.models;

import java.util.List;

public class Tag {
    private String id;
    private String text;
    private List<Spot> spots;

    public Tag() {}

    public Tag(String id, String text, List<Spot> spots) {
        this.id = id;
        this.text = text;
        this.spots = spots;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }
}
