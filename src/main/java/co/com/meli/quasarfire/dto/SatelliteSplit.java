package co.com.meli.quasarfire.dto;

import java.util.ArrayList;

public class SatelliteSplit {
    private double distance;
    private ArrayList<String> message;

    public SatelliteSplit() {
        super();
    }

    public SatelliteSplit(double distance, ArrayList<String> message) {
        this.distance = distance;
        this.message = message;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
