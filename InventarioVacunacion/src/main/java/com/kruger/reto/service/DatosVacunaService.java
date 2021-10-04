package com.kruger.reto.service;


import com.kruger.reto.entity.*;
import com.kruger.reto.repository.DatosVacunaRepository;
import com.kruger.reto.repository.EmpleadoRepository;
import com.kruger.reto.repository.VacunaEmpleadoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class DatosVacunaService {

    private EmpleadoRepository empleadoRepository;
    private DatosVacunaRepository datosVacunaRepository;
    private VacunaEmpleadoRepository vacunaEmpleadoRepository;

    public DatosVacunaService(EmpleadoRepository empleadoRepository, DatosVacunaRepository datosVacunaRepository,
                              VacunaEmpleadoRepository vacunaEmpleadoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.datosVacunaRepository = datosVacunaRepository;
        this.vacunaEmpleadoRepository = vacunaEmpleadoRepository;
    }

    @Transactional
    public String saveDatosVacuna(DatosVacunacion datos) {
        datosVacunaRepository.save(datos);
        Empleados e= empleadoRepository.findById(datos.getCedulaEmpleado()).get();
        e.setEstadoVacunacion("Vacunado");
        empleadoRepository.save(e);

        VacunacionEmpleado ve = new VacunacionEmpleado(datos.getCedulaEmpleado(), datos);

        vacunaEmpleadoRepository.save(ve);

        return "Información de Vacunación Se guardó exitosamente";
    }




}
