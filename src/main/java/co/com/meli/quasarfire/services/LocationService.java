package co.com.meli.quasarfire.services;

import co.com.meli.quasarfire.dto.Position;
import co.com.meli.quasarfire.dto.SatellitesReq;
import co.com.meli.quasarfire.entity.SatelliteEntity;
import co.com.meli.quasarfire.exception.ServiceException;
import co.com.meli.quasarfire.repository.QuasarFireRepository;
import com.lemmingapex.trilateration.LinearLeastSquaresSolver;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {


    @Autowired
    Environment environment;
    @Autowired
    QuasarFireRepository quasarFireRepository;

    /**
     * Función que procesa la información de los Satélites para encontrar la posición de la fuente
     * @param distances Distancias de los satelites
     * @return Posición de la fuente
     * @throws ServiceException
     */
    public Position getLocation(double[] distances) throws ServiceException {
        if (distances.length != 3) {
            throw new ServiceException("No se ingresaron la distancia por cada satelite");
        }
        List<SatelliteEntity> satellites = quasarFireRepository.findAll();
        double[][] positionSatellites = new double[satellites.size()][1];
        for (int i = 0; i < satellites.size(); i++){
            positionSatellites[i] = satellites.get(i).getPoint();
        }
        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positionSatellites, distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());
        Position position = new Position(nSolver.solve().getPoint().toArray());
        return position;
    }
}
