package co.com.meli.quasarfire.services;

import co.com.meli.quasarfire.dto.Response;
import co.com.meli.quasarfire.dto.Satellite;
import co.com.meli.quasarfire.dto.SatelliteSplit;
import co.com.meli.quasarfire.dto.SatellitesReq;
import co.com.meli.quasarfire.entity.SatelliteEntity;
import co.com.meli.quasarfire.exception.ServiceException;

import java.util.List;

public interface IQuasarFireService {

    Response getInformation(SatellitesReq satellitesReq) throws Exception;

    Response topSecretSplit(String satelliteName, SatelliteSplit satellite) throws Exception;

    Response getTopSecretSplit() throws Exception;

    List<SatelliteEntity> getSatellite(String satelliteName) throws Exception;

    List<SatelliteEntity> updateSatellites(String satelliteName) throws Exception;
}
