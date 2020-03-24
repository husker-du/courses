SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema courses_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `courses_db` ;

-- -----------------------------------------------------
-- Schema courses_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `courses_db` DEFAULT CHARACTER SET utf8 ;
USE `courses_db` ;

-- -----------------------------------------------------
-- Table `courses_db`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_db`.`teacher` ;

CREATE TABLE IF NOT EXISTS `courses_db`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courses_db`.`subject_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_db`.`subject_file` ;

CREATE TABLE IF NOT EXISTS `courses_db`.`subject_file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(100) NOT NULL,
  `type` VARCHAR(100) NULL,
  `data` LONGBLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courses_db`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_db`.`course` ;

CREATE TABLE IF NOT EXISTS `courses_db`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `level` ENUM('Básico', 'Intermedio', 'Avanzado') NOT NULL,
  `hours` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `id_teacher` INT NOT NULL,
  `id_file` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_teacher_idx` (`id_teacher` ASC),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC),
  INDEX `fk_course_file1_idx` (`id_file` ASC),
  CONSTRAINT `fk_course_teacher`
    FOREIGN KEY (`id_teacher`)
    REFERENCES `courses_db`.`teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_file1`
    FOREIGN KEY (`id_file`)
    REFERENCES `courses_db`.`subject_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `course` (`id`, `title`, `level`, `hours`, `active`, `id_teacher`, `id_file`) VALUES
	(1,'Introducción a JSF 2','Intermedio',25,1,2,NULL),
	(2,'Novedades en Java 8','Básico',10,1,3,NULL),
	(3,'Java para sistemas','Básico',25,0,4,NULL),
	(4,'Angular 2','Intermedio',25,1,5,NULL),
	(5,'Docker in Practice','Básico',10,1,1,NULL),
	(6,'C-Sharp for Dummies','Básico',22,1,2,NULL),
	(7,'NodeJS y Express','Intermedio',36,1,4,NULL),
	(8,'AS-400','Avanzado',400,0,3,NULL),
	(9,'Python 3','Básico',28,1,1,NULL),
	(10,'Taller de Marquetería','Intermedio',31,1,2,NULL),
	(11,'C++ para Espabilados','Avanzado',101,1,1,NULL),
	(12,'Cómo Contar Chistes Sin Gracia','Básico',9,0,5,NULL),
	(13,'Fundamentos de Aviónica','Básico',15,1,2,NULL),
	(14,'Administración de Redes','Intermedio',46,1,5,NULL),
	(15,'VueJS in Action','Avanzado',35,1,3,NULL),
	(16,'Django Framework','Avanzado',49,1,5,NULL),
	(17,'Machine Learning con Matlab','Avanzado',29,1,1,NULL),
	(18,'Macramé, Bordado y Punto de Cruz','Básico',75,1,1,NULL),
	(19,'Kubernetes','Avanzado',53,1,3,NULL),
	(20,'ADA','Básico',12,0,2,NULL),
	(21,'.NET Programming','Básico',44,1,2,NULL),
	(22,'Visual Basic','Básico',15,0,5,NULL),
	(23,'Java Modules Programming','Básico',8,1,1,NULL),
	(24,'English for Business','Intermedio',24,1,4,NULL),
	(25,'Curso de Swift','Básico',21,1,4,NULL),
	(26,'Lenguaje Ensamblador ARM','Avanzado',55,1,2,NULL);


INSERT INTO `teacher` (`id`, `first_name`, `last_name`, `age`) VALUES
	(1,'Alejandra','Mateos',30),
	(2,'Roberto','Canales',32),
	(3,'David','Gómez',29),
	(4,'Alberto','Moratilla',43),
	(5,'Rubén','Aguilera',30);

COMMIT;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
