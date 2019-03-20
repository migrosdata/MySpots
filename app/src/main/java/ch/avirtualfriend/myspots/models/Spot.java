package ch.avirtualfriend.myspots.models;

import java.util.Date;
import java.util.List;

public class Spot {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private Date inputDate;
    private String comments;
    private List<Tag> tags;
    private List<Picture> pictures;

    public Spot() {}

    public Spot(String id, String name, double latitude, double longitude, Date inputDate, String comments, List<Tag> tags, List<Picture> pictures) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.inputDate = inputDate;
        this.comments = comments;
        this.tags = tags;
        this.pictures = pictures;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Picture> getPictures() {
        return pictures;
    }
}
