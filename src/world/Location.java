package world;

import enums.LocationType;

import java.io.Serializable;
import java.util.Arrays;

public class Location implements Serializable {

    private String name;
    private int id;
    private int[] locations;
    private LocationType locationType;
    private boolean isLocked;

    public Location() {

    }

    public Location(String name, int id, String[] locations, LocationType locationType, boolean isLocked) {
        this.name = name;
        this.id = id;
        this.locations = new int[4];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Integer.parseInt(locations[i]);
        }
        this.locationType = locationType;
        this.isLocked = isLocked;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", locations=" + Arrays.toString(locations) +
                ", locationType=" + locationType +
                ", isLocked=" + isLocked +
                '}';
    }

    public Integer checkNeighbors(Location loc, int direction) {
        return loc.getLocations()[direction];
    }

    public int[] getLocations() {
        return locations;
    }

    public String getName() {
        return name;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getId() {
        return id;
    }
}
