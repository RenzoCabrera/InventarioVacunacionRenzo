package com.kruger.reto;

import com.kruger.reto.entity.Usuarios;
import com.kruger.reto.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class InventarioVacunacionApplicationTests {

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {

		Usuarios user = new Usuarios();
		user.setIdUsuario("admin");
		user.setClave(encoder.encode("12345"));

		repo.save(user);
	}

}
