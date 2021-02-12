package co.com.meli.quasarfire.services;

import co.com.meli.quasarfire.dto.*;

import co.com.meli.quasarfire.entity.SatelliteEntity;
import co.com.meli.quasarfire.exception.ServiceException;
import co.com.meli.quasarfire.repository.QuasarFireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuasarFireService implements IQuasarFireService{

    @Autowired
    LocationService locationService;

    @Autowired
    MessageService messageService;

    @Autowired
    QuasarFireRepository quasarFireRepository;

    @Override
    public Response getInformation(SatellitesReq satellitesReq) throws Exception {
        for(Satellite satellite: satellitesReq.getSatellites()){
            if(!(satellite.getName().contentEquals("kenobi") ||
                satellite.getName().contentEquals("skywalker") ||
                satellite.getName().contentEquals("sato")))
                throw new Exception("Los satelites ingresados no corresponden a los configurados");
        }
        double[] distances = new double[satellitesReq.getSatellites().size()];
        for (int i = 0; i < satellitesReq.getSatellites().size(); i++){
            distances[i] = satellitesReq.getSatellites().get(i).getDistance();
        }
        Position position = locationService.getLocation(distances);

        List<List<String>> messages = new ArrayList<>();
        for (int i = 0; i < satellitesReq.getSatellites().size(); i++){
            messages.add(satellitesReq.getSatellites().get(i).getMessage());
        }
        String message = messageService.getMessage(messages);
        Response response = new Response(message,position);
        return response;

    }
    @Override
    public Response topSecretSplit(String satelliteName, SatelliteSplit satellite) throws Exception {
        Response response = new Response();
        Optional<SatelliteEntity> satellitesEntity = quasarFireRepository.findById(satelliteName);
        if(!satellitesEntity.isPresent()){
            throw new Exception("El nombre del satélite es diferente a los registrados");
        }
        SatelliteEntity satelliteEntity = satellitesEntity.get();
        satelliteEntity.setDistance(satellite.getDistance());
        satelliteEntity.setMessage(satellite.getMessage().toString());
        quasarFireRepository.save(satelliteEntity);
        response.setMessage(String.format("Se guardan los valores del satelite: %s", satelliteName));
        return response;
    }
    @Override
    public Response getTopSecretSplit() throws Exception {
        Response response;
        List<SatelliteEntity> satellites = quasarFireRepository.findAll();
            SatellitesReq satellitesReq = new SatellitesReq();
            List<Satellite> satellitesList = new ArrayList<>();
            for (int i = 0; i < satellites.size(); i++) {
                Satellite satellite = new Satellite();
                satellite.setDistance(satellites.get(i).getDistance());
                String messages = satellites.get(i).getMessage();
                messages = messages.replace("[","");
                messages = messages.replace("]","");
                String str[] = messages.split(",");
                ArrayList<String> al = new ArrayList<String>();
                al = new ArrayList<>(Arrays.asList(str));
                satellite.setMessage(al);
                satellitesList.add(satellite);
            }
            satellitesReq.setSatellites(satellitesList);
            response = getInformation(satellitesReq);

        return response;
    }
}
