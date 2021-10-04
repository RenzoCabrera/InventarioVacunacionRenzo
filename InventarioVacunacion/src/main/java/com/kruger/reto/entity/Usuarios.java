package com.kruger.reto.entity;


import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {

    @Id
    @Column(name = "id_usuario")
    private String idUsuario;

    private String clave;

    @ManyToOne
    @JoinColumn(name="cedula_empleado")
    private Empleados tblEmpleado;

    public Usuarios() {
    }

    public Usuarios(String idUsuario, String clave, Empleados tblEmpleado) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.tblEmpleado = tblEmpleado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Empleados getTblEmpleado() {
        return tblEmpleado;
    }

    public void setTblEmpleado(Empleados tblEmpleado) {
        this.tblEmpleado = tblEmpleado;
    }
}
