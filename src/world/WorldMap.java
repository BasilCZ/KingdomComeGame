package world;

import enums.LocationType;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class WorldMap implements Serializable {

    private static HashMap<Integer, Location> kuttenberg = new HashMap<>();
    private static HashMap<Integer, Location> trosky = new HashMap<>();
    private static HashMap<Integer, Location> current = new HashMap<>();
    private int start = 0;
    private static int currentPosition = 0;

    //Loads all the rooms from the file
    public static boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("kuttenberg.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 2, 6),
                        LocationType.valueOf(lines[6])
                );
                kuttenberg.put(Integer.valueOf(lines[0]), location);
            }
        } catch (IOException e) {
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("trosky.csv"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        lines[1],
                        Integer.parseInt(lines[0]),
                        Arrays.copyOfRange(lines, 2, 6),
                        LocationType.valueOf(lines[6])
                );
                trosky.put(Integer.valueOf(lines[0]), location);
            }
            current = trosky;
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Location getCurrentPosition() {
        return current.get(currentPosition);
    }

    public int getCurrentId() {
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition) {
        currentPosition = newPosition;
    }

    public String getName() {
        return current.get(currentPosition).getName();
    }

    public String getNameOf(int index){
        return current.get(index).getName();
    }

    public void goToTrosky(){
        WorldMap.current = trosky;
        setCurrentPosition(7);
    }

    public void goToKuttenberg(){
        WorldMap.current = kuttenberg;
        setCurrentPosition(14);
    }
}
