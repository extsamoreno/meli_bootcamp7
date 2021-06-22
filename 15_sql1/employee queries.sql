CREATE TABLE IF NOT EXISTS `emple_dep`.`Department` (
  `idDepartment` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartment`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `emple_dep`.`Employee` (
  `nroLegajo` INT NOT NULL AUTO_INCREMENT,
  `dni` NVARCHAR(9) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATETIME NOT NULL,
  `fechaIncorporacion` DATETIME NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `sueldoNeto` DECIMAL(10) NOT NULL,
  `Department_idDepartment` INT NOT NULL,
  PRIMARY KEY (`nroLegajo`, `Department_idDepartment`),
  INDEX `fk_Employee_Department_idx` (`Department_idDepartment` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Department`
    FOREIGN KEY (`Department_idDepartment`)
    REFERENCES `emple_dep`.`Department` (`idDepartment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

INSERT INTO Department(nombre, direccion)
VALUES("Contable", "Calle Falsa 123"),
("Técnico", "Calle Falsa 123"),
("Legales", "Calle Falsa 345"),
("Administrativo", "Calle Falsa 345"),
("RRHH", "Siempre Viva 1233");

SELECT * FROM Department;

INSERT INTO Employee(dni, apellido, nombre, fechaNacimiento, fechaIncorporacion, cargo, sueldoNeto, Department_idDepartment)
VALUES
("1111222", "Juarez", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 100.000, 1),
("1111223", "Duarez", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 100.000, 1),
("1111224", "Juarez", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 101.000, 1),
("1111225", "Juarez", "Jorges", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 102.000, 5),
("1111226", "Juares", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Contador", 103.000, 4),
("1111227", "Vazquez", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 104.000, 3),
("1111228", "Lopez", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 105.000, 2),
("1111229", "Walls", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Contador", 106.000, 2),
("1111222", "Phelps", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 107.000, 3),
("1111232", "Uss", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 108.000, 3),
("1111242", "Casal", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Contador", 109.000, 4),
("1111252", "Moll", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 110.000, 4),
("1111262", "Price", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Abogado", 100.100, 4),
("1111272", "Whis", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Abogado", 100.200, 5),
("1111282", "Ans", "Jorge", '1985-12-11 10:00:00', '2021-11-11 10:00:00', "Desarrollador", 100.300, 5);

SELECT * FROM Employee;