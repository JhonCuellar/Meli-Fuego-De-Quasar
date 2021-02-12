package co.com.meli.quasarfire.services;

import co.com.meli.quasarfire.dto.Response;
import co.com.meli.quasarfire.dto.Satellite;
import co.com.meli.quasarfire.dto.SatelliteSplit;
import co.com.meli.quasarfire.dto.SatellitesReq;
import co.com.meli.quasarfire.entity.SatelliteEntity;
import co.com.meli.quasarfire.exception.ServiceException;

public interface IQuasarFireService {

    Response getInformation(SatellitesReq satellitesReq) throws Exception;

    Response topSecretSplit(String satelliteName, SatelliteSplit satellite) throws Exception;

    Response getTopSecretSplit() throws Exception;
}
