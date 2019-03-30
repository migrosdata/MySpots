package ch.avirtualfriend.myspots.services;

import java.util.Collection;
import java.util.List;

import ch.avirtualfriend.myspots.models.Spot;

public interface ISpotService {
     List<Spot> getAllSpots();
     void addSpot(Spot spot);
}
