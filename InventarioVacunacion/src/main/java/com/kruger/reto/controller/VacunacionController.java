package com.kruger.reto.controller;


import com.kruger.reto.entity.DatosVacunacion;
import com.kruger.reto.service.DatosVacunaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacunacion")
public class VacunacionController {

    private DatosVacunaService datosVacunaService;


    public VacunacionController(DatosVacunaService datosVacunaService) {
        this.datosVacunaService = datosVacunaService;
    }

    @PostMapping("/save")
    @ApiOperation(value = "Crea la información de la Vacunación")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<String> save(@RequestBody DatosVacunacion datosVacunacion) {
        return new ResponseEntity<>(datosVacunaService.saveDatosVacuna(datosVacunacion), HttpStatus.CREATED);
    }



}
