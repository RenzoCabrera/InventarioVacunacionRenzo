package com.kruger.reto.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EMPLEADOS")
public class Empleados {

    @Id
    private String cedula;

    private String nombres;
    private String apellidos;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion_domicilio")
    private String direccionDomicilio;

    @Column(name = "telefono_movil")
    private String telefonoMovil;

    @Column(name = "estado_vacunacion")
    private String estadoVacunacion;

    @OneToMany(mappedBy = "cedulaEmpleado")
    private List<VacunacionEmpleado> listVacunas;


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(String estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public List<VacunacionEmpleado> getListVacunas() {
        return listVacunas;
    }

    public void setListVacunas(List<VacunacionEmpleado> listVacunas) {
        this.listVacunas = listVacunas;
    }
}
