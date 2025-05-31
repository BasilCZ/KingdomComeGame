package world;

import enums.LocationType;

import java.io.Serializable;
import java.util.Arrays;

public class Location implements Serializable {

    private String name;
    private int id;
    private int[] locations;
    private LocationType locationType;

    public Location() {

    }

    public Location(String name, int id, String[] locations, LocationType locationType) {
        this.name = name;
        this.id = id;
        this.locations = new int[4];
        for (int i = 0; i < locations.length; i++) {
            this.locations[i] = Integer.parseInt(locations[i]);
        }
        this.locationType = locationType;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", locations=" + Arrays.toString(locations) +
                ", locationType=" + locationType +
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

    public LocationType getLocationType() {
        return locationType;
    }

    /**
     * Checks all the neighboring rooms.
     * @return <code>String</code> All the possible moves, to which you can move to.
     */
    public String getPossibleMoves() {
        String possibleMoves = "Possible moves:";
        WorldMap wm = new WorldMap();

        for (int i = 0; i < locations.length; i++) {
            switch(i){
                case 0:
                    possibleMoves += " up: ";
                    break;
                case 1:
                    possibleMoves += " down: ";
                    break;
                case 2:
                    possibleMoves += " left: ";
                    break;
                case 3:
                    possibleMoves += " right: ";
                    break;
            }
            if(locations[i] != -1){
                possibleMoves += wm.getNameOf(locations[i]) + ",";
            } else {
                possibleMoves += "Nothing,";
            }
        }
        //ChatGPT
        possibleMoves = possibleMoves.substring(0, possibleMoves.length() - 1);
        return possibleMoves;
    }
}
