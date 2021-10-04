package com.kruger.reto.entity;


import javax.persistence.*;

@Entity
@Table(name = "USUARIO_ROLES")
public class UserRoles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_rol")
    private Integer idUserRol;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuarios tblUsuario;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private Roles tblRol;

    public UserRoles() {
    }

    public UserRoles(Usuarios tblUsuario, Roles tblRol) {
        this.tblUsuario = tblUsuario;
        this.tblRol = tblRol;
    }

    public Integer getIdUserRol() {
        return idUserRol;
    }

    public void setIdUserRol(Integer idUserRol) {
        this.idUserRol = idUserRol;
    }

    public Usuarios getTblUsuario() {
        return tblUsuario;
    }

    public void setTblUsuario(Usuarios tblUsuario) {
        this.tblUsuario = tblUsuario;
    }

    public Roles getTblRol() {
        return tblRol;
    }

    public void setTblRol(Roles tblRol) {
        this.tblRol = tblRol;
    }
}
