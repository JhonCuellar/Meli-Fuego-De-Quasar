package co.com.meli.quasarfire.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SATELLITES")
public class SatelliteEntity {

    @Id
    private String name;
    private Double distance;
    private Double x;
    private Double y;
    private String message;

    public SatelliteEntity(){
        super();
    }
    public SatelliteEntity(String name, Double distance, Double x, Double y, String message) {
        this.name = name;
        this.distance = distance;
        this.x = x;
        this.y = y;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SatelliteEntity{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", x=" + x +
                ", y=" + y +
                ", message='" + message + '\'' +
                '}';
    }
    public double[] getPoint() {
        return new double[]{x, y};
    }
}
