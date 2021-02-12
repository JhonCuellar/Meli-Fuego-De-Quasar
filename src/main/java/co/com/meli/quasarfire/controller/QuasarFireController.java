package co.com.meli.quasarfire.controller;

import co.com.meli.quasarfire.dto.Response;
import co.com.meli.quasarfire.dto.SatelliteSplit;
import co.com.meli.quasarfire.dto.SatellitesReq;
import co.com.meli.quasarfire.services.IQuasarFireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Objects;

@RestController
@RequestMapping
@Api(value = "QuasarFireController: Controlador que contiene las operacions del API para el cumplimiento de la Operación fuego de Quasar" )
public class QuasarFireController {

    @Autowired
    IQuasarFireService iQuasarFireService;

    @ApiOperation(value = "Método para obtener la posición y mensaje", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = Response.class, message = "OK"),
            @ApiResponse(code = 404, response = Response.class, message = "Not found") })
    @PostMapping("topsecret")
    public ResponseEntity<Response> topSecret(@RequestBody SatellitesReq requestSatellites) throws Exception {
        Response response = new Response();
        try {
            if(Objects.isNull(requestSatellites))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se reciven datos para obtener el mensaje y la distancia");
            if(requestSatellites.getSatellites().size() != 3)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Se debén recibir solo los 3 satélites especificados");
            response = iQuasarFireService.getInformation(requestSatellites);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @ApiOperation(value = "Método para almacernar el registro del satelite", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = Response.class, message = "OK"),
            @ApiResponse(code = 404, response = Response.class, message = "Not found") })
    @PostMapping("topsecret_split/{satellite_name}")
    public ResponseEntity<Response> topSecretSplit(@PathVariable("satellite_name") String satelliteName,
                                                       @RequestBody SatelliteSplit satellite){
        Response response = new Response();
        try {
            response = iQuasarFireService.topSecretSplit(satelliteName,satellite);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e)
        {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @ApiOperation(value = "Método para obtener la posición y mensaje a partir de los registrados en la base de datos", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = Response.class, message = "OK"),
            @ApiResponse(code = 404, response = Response.class, message = "Not found") })
    @GetMapping("topsecret_split")
    public ResponseEntity<Response> getTopSecretSplit() throws Exception{
        Response response = new Response();
        try {
            response = iQuasarFireService.getTopSecretSplit();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e) {
            response.setMessage("No hay suficiente información para calcular la distacia o el mensaje");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
