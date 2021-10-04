package com.kruger.reto.controller;


import com.kruger.reto.entity.Empleados;
import com.kruger.reto.service.EmpleadoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Obtiene la Lista de Empleados")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Empleados>> getAll() {

        return new ResponseEntity<>(empleadoService.getAllEmpleados(), HttpStatus.OK);
    }

    @GetMapping("getByCedula/{cedula}")
    @ApiOperation(value = "Obtiene Empleado por cédula")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Empleado not found"),
    })
    public ResponseEntity<Empleados> getEmpleado(@ApiParam(value = "La cédula del Empleado", required = true, example = "0925254351")
                                                     @PathVariable("cedula") String cedula) {
        return empleadoService.getEmpleado(cedula)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation(value = "Crea la información del empleado una vez creado el empleado crea su usuario")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<String> save(@RequestBody Empleados empleado) {
        return new ResponseEntity<>(empleadoService.saveEmpleado(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/update/{cedula}")
    @ApiOperation(value = "Edita La información del empleado")
    @ApiResponse(code = 200, message = "OK")

        ResponseEntity <String> updateEmpleado (@RequestBody Empleados newEmpleado, @PathVariable String cedula ){
        return new ResponseEntity<>(empleadoService.updateEmpleado(newEmpleado, cedula), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cedula}")
    @ApiOperation(value = "Elimina al empleado por cédula")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Empleado not found"),})
    public ResponseEntity delete(@PathVariable("cedula") String cedula) {
        if (empleadoService.delete(cedula)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }




}
