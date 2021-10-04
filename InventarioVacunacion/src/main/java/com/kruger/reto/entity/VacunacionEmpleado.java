package com.kruger.reto.entity;


import javax.persistence.*;

@Entity
@Table(name = "VACUNACION_EMPLEADO")
public class VacunacionEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna_empleado")
    private Integer idVacunaEmpleado;


    @Column(name = "cedula_empleado")
    private String cedulaEmpleado;


    @ManyToOne
    @JoinColumn(name="dato_vacunacion_id")
    private DatosVacunacion tblDatosVacuna;

    public VacunacionEmpleado() {
    }

    public VacunacionEmpleado(String cedulaEmpleado, DatosVacunacion tblDatosVacuna) {
        this.cedulaEmpleado = cedulaEmpleado;
        this.tblDatosVacuna = tblDatosVacuna;
    }

    public Integer getIdVacunaEmpleado() {
        return idVacunaEmpleado;
    }

    public void setIdVacunaEmpleado(Integer idVacunaEmpleado) {
        this.idVacunaEmpleado = idVacunaEmpleado;
    }



    public DatosVacunacion getTblDatosVacuna() {
        return tblDatosVacuna;
    }

    public void setTblDatosVacuna(DatosVacunacion tblDatosVacuna) {
        this.tblDatosVacuna = tblDatosVacuna;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }
}
