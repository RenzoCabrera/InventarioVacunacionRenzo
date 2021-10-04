package com.kruger.reto.repository;

import com.kruger.reto.entity.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Integer> {

    Roles findBynombreRol(String name);
}
