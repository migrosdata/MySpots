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
}
