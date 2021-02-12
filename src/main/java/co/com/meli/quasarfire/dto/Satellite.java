package co.com.meli.quasarfire.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

public class Satellite {
    @ApiModelProperty(notes = "Nombre del satélite",name="name",required=false)
    private String name;
    @ApiModelProperty(notes = "Distancia a la fuente del mensaje",name="distance",required=false)
    private double distance;
    @ApiModelProperty(notes = "Mensaje recibido",name="message",required=false)
    private ArrayList<String> message;

    public Satellite() {
        super();
    }

    public Satellite(String name, double distance, ArrayList<String> message) {
        super();
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Satellite{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", message=" + message +
                '}';
    }
}
