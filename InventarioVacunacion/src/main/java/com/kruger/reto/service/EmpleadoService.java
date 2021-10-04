package com.kruger.reto.service;


import com.kruger.reto.entity.Empleados;
import com.kruger.reto.entity.Roles;
import com.kruger.reto.entity.UserRoles;
import com.kruger.reto.entity.Usuarios;
import com.kruger.reto.repository.EmpleadoRepository;
import com.kruger.reto.repository.RolesRepository;
import com.kruger.reto.repository.UserRepository;
import com.kruger.reto.repository.UserRolesRepository;
import com.kruger.reto.utils.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;
    private Validations validations;
    private UserRepository userRepository;
    private UserRolesRepository userRolesRepository;
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public EmpleadoService(EmpleadoRepository empleadoRepository, Validations validations,
                           UserRepository userRepository, UserRolesRepository userRolesRepository, RolesRepository rolesRepository) {
        this.empleadoRepository = empleadoRepository;
        this.validations = validations;
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.rolesRepository = rolesRepository;
    }

    public List<Empleados> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleados> getEmpleado(String cedula) {
        return empleadoRepository.findById(cedula);
    }


    @Transactional
    public String saveEmpleado(Empleados newEmpleado) {

        if (newEmpleado.getCedula()== null || newEmpleado.getNombres()== null ||
                newEmpleado.getApellidos()== null || newEmpleado.getCorreoElectronico()== null){
            return "No deben existir Valores Nulos";
        }

        if (!validations.validarCedula(newEmpleado.getCedula())) {
            return "Error al Ingresar, cédula Incorrecta";
        }

        if (!validations.validarPatron(newEmpleado.getCorreoElectronico(), "CORREO")) {
            return "Error al Ingresar, correo electrónico Incorrecto";
        }

        if (!validations.validarPatron(newEmpleado.getNombres(), "NOMBRES")) {
            return "Error al Ingresar, No se permiten caracteres especiales ni números en los Nombres";
        }

        if (!validations.validarPatron(newEmpleado.getApellidos(), "NOMBRES")) {
            return "Error al Ingresar, No se permiten caracteres especiales ni números en los Apellidos";
        }


        Empleados emp = empleadoRepository.save(newEmpleado);

        Usuarios user = new Usuarios(emp.getCedula(),encoder.encode("12345"), emp);
        userRepository.save(user);

        Roles rol = rolesRepository.findBynombreRol("Empleado");

        UserRoles ur = new UserRoles(user, rol);
        userRolesRepository.save(ur);

        return "Empleado creado exitosamente, Se generó las credenciales para el usuario usuario es el número de cédula, la contraseña es : 12345";



    }


    public String updateEmpleado(Empleados newEmpleado, String cedula) {

        if (newEmpleado.getCedula().compareTo(cedula)!=0){
            return "Cédulas deben de ser iguales";
        }

        if (!validations.validarPatron(newEmpleado.getCorreoElectronico(), "CORREO")) {
            return "Error al Ingresar, correo electrónico Incorrecto";
        }

        if (!validations.validarPatron(newEmpleado.getNombres(), "NOMBRES")) {
            return "Error al Ingresar, No se permiten caracteres especiales ni números en los Nombres";
        }

        if (!validations.validarPatron(newEmpleado.getApellidos(), "NOMBRES")) {
            return "Error al Ingresar, No se permiten caracteres especiales ni números en los Apellidos";
        }

        Empleados empUp =empleadoRepository.findById(cedula).
                map(emp -> {
                            emp.setNombres(newEmpleado.getNombres());
                            emp.setApellidos(newEmpleado.getApellidos());
                            emp.setCorreoElectronico(newEmpleado.getCorreoElectronico());
                            emp.setFechaNacimiento(newEmpleado.getFechaNacimiento());
                            emp.setDireccionDomicilio(newEmpleado.getDireccionDomicilio());

                            return empleadoRepository.save(newEmpleado);
                        }
                ).get();


        return "Empleado actualizado exitosamente";


    }


    @Transactional
    public boolean delete(String cedula) {

        boolean response= false;
        userRolesRepository.findByTblUsuario(userRepository.findById(cedula).get()).stream().forEach(ur ->
            userRolesRepository.delete(ur));


        response=  userRepository.findById(cedula).map(u -> {
            userRepository.delete(u);
            return true;
        }).orElse(false);

        response = empleadoRepository.findById(cedula).map(emp -> {
            empleadoRepository.delete(emp);
            return true;
        }).orElse(false);


        return response;

    }


    public List<Empleados> getReporte(String estado, Integer idTipoVacuna, LocalDate desde, LocalDate hasta) {
        return empleadoRepository.findReporte(estado, idTipoVacuna, desde, hasta);
    }



}
