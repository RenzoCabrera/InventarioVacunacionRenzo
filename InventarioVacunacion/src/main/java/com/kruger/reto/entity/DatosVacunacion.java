package com.kruger.reto.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DATOS_VACUNACION")
public class DatosVacunacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dato_vacunacion")
    private Integer idDatoVacunacion;


    @Transient
    private String cedulaEmpleado;


    @ManyToOne
    @JoinColumn(name="tipo_vacuna_id", insertable = false, updatable = false)
    private TipoVacuna tblTipoVacuna;

    @Column(name = "tipo_vacuna_id")
    private Integer idVacuna;

    @Column(name = "fecha_vacunacion")
    private LocalDate fechaVacunacion;

    @Column(name = "numero_dosis")
    private Integer numeroDosis;


    public Integer getIdDatoVacunacion() {
        return idDatoVacunacion;
    }

    public void setIdDatoVacunacion(Integer idDatoVacunacion) {
        this.idDatoVacunacion = idDatoVacunacion;
    }


    public TipoVacuna getTblTipoVacuna() {
        return tblTipoVacuna;
    }

    public void setTblTipoVacuna(TipoVacuna tblTipoVacuna) {
        this.tblTipoVacuna = tblTipoVacuna;
    }

    public LocalDate getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(LocalDate fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public Integer getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(Integer numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }
}
