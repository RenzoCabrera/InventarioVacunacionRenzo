package com.kruger.reto.service;

import com.kruger.reto.entity.UserRoles;
import com.kruger.reto.entity.Usuarios;
import com.kruger.reto.repository.UserRepository;
import com.kruger.reto.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class KrugerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    //@Autowired
    //private BCryptPasswordEncoder encoder;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> us = userRepository.findById(username);
        List<UserRoles> ur = userRolesRepository.findByTblUsuario(us.get());

        List<GrantedAuthority> roles = new ArrayList<>();
        ur.stream().forEach(u -> roles.add(new SimpleGrantedAuthority(u.getTblRol().getNombreRol())));


        UserDetails userDet = new User(us.get().getIdUsuario(), us.get().getClave(), roles);

        return userDet;
    }
}
