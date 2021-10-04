package com.kruger.reto.repository;

import com.kruger.reto.entity.UserRoles;
import com.kruger.reto.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRolesRepository extends CrudRepository<UserRoles, Integer> {

    List<UserRoles> findByTblUsuario(Usuarios username);
}
