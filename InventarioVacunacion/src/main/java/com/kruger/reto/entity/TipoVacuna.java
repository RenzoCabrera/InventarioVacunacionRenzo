package com.kruger.reto.entity;


import javax.persistence.*;

@Entity
@Table(name = "TIPOS_VACUNA")
public class TipoVacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_vacuna")
    private Integer idTipoVacuna;

    @Column(name = "nombre_vacuna")
    private String nombreVacuna;


    public Integer getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public void setIdTipoVacuna(Integer idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
}
