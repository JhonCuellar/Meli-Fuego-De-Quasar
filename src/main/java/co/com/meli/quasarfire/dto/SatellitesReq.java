package co.com.meli.quasarfire.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SatellitesReq {
    @ApiModelProperty(notes = "Satélites recibidos",name="satellites",required=true)
    private List<Satellite> satellites;

    public SatellitesReq() {
        super();
    }

    public SatellitesReq(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }
}
