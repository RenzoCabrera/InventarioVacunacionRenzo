package com.kruger.reto.repository;

import com.kruger.reto.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuarios, String> {
}
