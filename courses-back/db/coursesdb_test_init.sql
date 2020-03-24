SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema courses_db_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `courses_db_test` ;

-- -----------------------------------------------------
-- Schema courses_db_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `courses_db_test` DEFAULT CHARACTER SET utf8 ;
USE `courses_db_test` ;

-- -----------------------------------------------------
-- Table `courses_db_test`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_db_test`.`teacher` ;

CREATE TABLE IF NOT EXISTS `courses_db_test`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courses_db_test`.`subject_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_db_test`.`subject_file` ;

CREATE TABLE IF NOT EXISTS `courses_db_test`.`subject_file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(100) NOT NULL,
  `type` VARCHAR(100) NULL,
  `data` LONGBLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courses_db_test`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_db_test`.`course` ;

CREATE TABLE IF NOT EXISTS `courses_db_test`.`course` (
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
    REFERENCES `courses_db_test`.`teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_file1`
    FOREIGN KEY (`id_file`)
    REFERENCES `courses_db_test`.`subject_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `course` (`id`, `title`, `level`, `hours`, `active`, `id_teacher`, `id_file`) VALUES
	(1,'Introducción a JSF 2','Intermedio',25,1,2,NULL),
	(2,'Novedades en Java 8','Básico',10,1,3,NULL),
	(3,'Java para sistemas','Básico',25,0,4,NULL),
	(4,'Angular 2','Intermedio',25,1,5,NULL);


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
