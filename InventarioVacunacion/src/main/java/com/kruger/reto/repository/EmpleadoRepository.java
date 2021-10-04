package com.kruger.reto.repository;

import com.kruger.reto.entity.Empleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EmpleadoRepository extends CrudRepository<Empleados, String> {
    List<Empleados> findAll();

    @Query("Select u from Empleados u  "+
            "WHERE u.cedula in (SELECT v.cedulaEmpleado FROM VacunacionEmpleado v " +
            "                   WHERE v.cedulaEmpleado = u.cedula "+
            "                   AND v.tblDatosVacuna.tblTipoVacuna.idTipoVacuna = :idTipoVacuna " +
            "                   AND DATE(v.tblDatosVacuna.fechaVacunacion) BETWEEN :desde and :hasta )" +
            "AND u.estadoVacunacion = :estado")
    List<Empleados> findReporte(@Param("estado") String estado, @Param("idTipoVacuna") Integer idTipoVacuna,
                                @Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta);

}
