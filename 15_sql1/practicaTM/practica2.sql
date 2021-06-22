create schema emple_dep;
use emple_dep;

CREATE TABLE `departamento` (
  `departamento_id` bigint NOT NULL auto_increment,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`departamento_id`),
  UNIQUE KEY `departamento_id_UNIQUE` (`departamento_id`)
);

CREATE TABLE `empleado` (
  `nro_legajo` bigint NOT NULL auto_increment,
  `dni` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `fecha_incorporacion` datetime DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `sueldo_neto` float DEFAULT NULL,
  `depto` bigint DEFAULT NULL,
  PRIMARY KEY (`nro_legajo`),
  UNIQUE KEY `nro_legajo_UNIQUE` (`nro_legajo`),
  KEY `depto` (`depto`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`depto`) REFERENCES `departamento` (`departamento_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

 INSERT INTO departamento (nombre,direccion) values("Depto1","Zona norte");
 INSERT INTO departamento (nombre,direccion) values("Depto2","Zona sur");
 INSERT INTO departamento (nombre,direccion) values("Depto3","Zona oeste");
 INSERT INTO departamento (nombre,direccion) values("Depto4","Zona este");
 INSERT INTO departamento (nombre,direccion) values("Depto5","Zona centro");
 
 INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10001', 'Empleado1', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '1');
 INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10002', 'Empleado2', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '2');
 INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10003', 'Empleado3', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '3');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10004', 'Empleado4', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '4');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10005', 'Empleado5', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '5');
    
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10006', 'Empleado6', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '1');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10007', 'Empleado7', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '2');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10008', 'Empleado8', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '3');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10009', 'Empleado9', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '4');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10010', 'Empleado10', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '5');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10011', 'Empleado11', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '1');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10012', 'Empleado12', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '2');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10013', 'Empleado13', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '3');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10014', 'Empleado14', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '4');
INSERT INTO empleado ( dni, nombre, apellido, fecha_nacimiento, fecha_incorporacion, cargo, sueldo_neto, depto) 
	VALUES ('10015', 'Empleado15', 'Perez', '2000-06-19', '2021-06-22', 'Gerente', '250000', '5');
    
 -- drop schema emple_dep;

