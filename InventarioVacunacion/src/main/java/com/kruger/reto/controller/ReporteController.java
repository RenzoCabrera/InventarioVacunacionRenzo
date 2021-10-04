package com.kruger.reto.controller;

import com.kruger.reto.entity.Empleados;
import com.kruger.reto.service.EmpleadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    private EmpleadoService empleadoService;

    public ReporteController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Obtiene Reporte de Empleado por Estado de Vacunación, Por tipo de Vacuna y/o Por rango de fecha")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Empleado not found"),
    })
    public ResponseEntity<List<Empleados>> getEmpleado(@ApiParam(value = "Estado de Vacunación", required = false, example = "No Vacunado")
                                @RequestParam(required = false) String estado,
                                                       @ApiParam(value = "Tipo de Vacuna", required = false, example = "1")
                                @RequestParam(required = false) Integer idTipoVacuna,
                                                       @ApiParam(value = "Fecha Desde", required = false, example = "1")
                                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate desde,
                                                       @ApiParam(value = "Fecha Hasta", required = false, example = "1")
                                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate hasta) {
        return new ResponseEntity<>(empleadoService.getReporte(estado, idTipoVacuna, desde, hasta), HttpStatus.OK);

    }

}
