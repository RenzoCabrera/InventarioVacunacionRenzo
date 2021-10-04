create DATABASE vacunacion;

-- -----------------------------------------------------
-- Table "EMPLEADOS"
-- -----------------------------------------------------
CREATE TABLE  EMPLEADOS (
  "cedula" 							VARCHAR(10) NOT NULL,
  "nombres" 						VARCHAR(40) NOT NULL,
  "apellidos" 						VARCHAR(40) NOT NULL,
  "correo_electronico" 				VARCHAR(70) NOT NULL,
  "fecha_nacimiento" 				TIMESTAMP NULL,
  "direccion_domicilio" 			VARCHAR(80) NULL,
  "telefono_movil" 					VARCHAR(20) NULL,
  "estado_vacunacion" 				VARCHAR(20) NULL,
  PRIMARY KEY ("cedula"));


-- -----------------------------------------------------
-- Table "USUARIOS"
-- -----------------------------------------------------
CREATE TABLE USUARIOS(
	"id_usuario" 					VARCHAR(150) NOT NULL,
	"clave" 						VARCHAR(150) NOT NULL,
	"cedula_empleado" 				VARCHAR(20)  NULL,
  
  PRIMARY KEY ("id_usuario"),
  CONSTRAINT "fk_USUARIO_EMPLEADOS1"
    FOREIGN KEY ("cedula_empleado")
    REFERENCES EMPLEADOS ("cedula")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "ROLES"
-- -----------------------------------------------------
CREATE TABLE ROLES(
	"id_rol"						SERIAL NOT NULL,
	"nombre_rol"					VARCHAR(150) NOT NULL,
	PRIMARY KEY ("id_rol")			
);



-- -----------------------------------------------------
-- Table "USUARIO_ROLES"
-- -----------------------------------------------------
CREATE TABLE USUARIO_ROLES(
	"id_user_rol"					SERIAL NOT NULL,
	"usuario_id"					VARCHAR(150),
	"rol_id"						INT NULL,
PRIMARY KEY ("id_user_rol"),
  CONSTRAINT "fk_USUARIO_ROLES1"
    FOREIGN KEY ("usuario_id")
    REFERENCES USUARIOS ("id_usuario")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_USUARIO_ROLES2"
    FOREIGN KEY ("rol_id")
    REFERENCES ROLES ("id_rol")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table "TIPO_VACUNA"
-- -----------------------------------------------------
CREATE TABLE  TIPOS_VACUNA (
  "id_tipo_vacuna" SERIAL NOT NULL,
  "nombre_vacuna" VARCHAR(45) NULL,
  PRIMARY KEY ("id_tipo_vacuna"));


-- -----------------------------------------------------
-- Table "DATOS_VACUNACION"
-- -----------------------------------------------------
CREATE TABLE  DATOS_VACUNACION (
  "id_dato_vacunacion" SERIAL NOT NULL,
  "cedula_empleado" VARCHAR(10) NOT NULL,
  "tipo_vacuna_id" INT NULL,
  "fecha_vacunacion" TIMESTAMP NULL,
  "numero_dosis" INT NULL,
  PRIMARY KEY ("id_dato_vacunacion"),
  CONSTRAINT "fk_VACUNACION_EMPLEADOS1"
    FOREIGN KEY ("cedula_empleado")
    REFERENCES EMPLEADOS ("cedula")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_TIPO_VACUNAS1"
    FOREIGN KEY ("tipo_vacuna_id")
    REFERENCES TIPOS_VACUNA ("id_tipo_vacuna")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	
	
	
INSERT INTO USUARIOS VALUES ('admin', 'admin', null);

INSERT INTO ROLES VALUES ( DEFAULT, 'Administrador');
INSERT INTO ROLES VALUES ( DEFAULT, 'Empleado');


INSERT INTO USUARIO_ROLES VALUES(DEFAULT,'admin',1);

INSERT INTO TIPOS_VACUNA VALUES(DEFAULT,'Sputnik');
INSERT INTO TIPOS_VACUNA VALUES(DEFAULT,'AstraZeneca');
INSERT INTO TIPOS_VACUNA VALUES(DEFAULT,'Pfizer');
INSERT INTO TIPOS_VACUNA VALUES(DEFAULT,'Jhonson&Jhonson');





