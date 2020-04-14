-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DBpegadapessoal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DBpegadapessoal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBpegadapessoal` DEFAULT CHARACTER SET utf8 ;
USE `DBpegadapessoal` ;

-- -----------------------------------------------------
-- Table `DBpegadapessoal`.`Pegada_Individual`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBpegadapessoal`.`Pegada_Individual` (
  `idPegada_Individual` INT NOT NULL AUTO_INCREMENT,
  `Nome_Individual` VARCHAR(100) NOT NULL,
  `CPF_Individual` VARCHAR(20) NOT NULL,
  `Temp_Carro` INT NOT NULL,
  `Temp_bus` INT NOT NULL,
  `Vol_Lixo` INT NOT NULL,
  `Pegada_Total` DOUBLE NOT NULL,
  `CEP_Individual` VARCHAR(20) NOT NULL,
  `Complemento_Individual` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPegada_Individual`),
  UNIQUE INDEX `CPF_Individual_UNIQUE` (`CPF_Individual` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBpegadapessoal`.`Bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBpegadapessoal`.`Bairro` (
  `idBairro` INT NOT NULL AUTO_INCREMENT,
  `Nome_Bairro` VARCHAR(45) NOT NULL,
  `Regiao` VARCHAR(45) NOT NULL,
  `Volume_CO2` DOUBLE NOT NULL,
  `Pegada_Individual_idPegada_Individual` INT NOT NULL,
  `Area` DOUBLE NOT NULL,
  PRIMARY KEY (`idBairro`),
  INDEX `fk_Bairro_Pegada_Individual_idx` (`Pegada_Individual_idPegada_Individual` ASC) VISIBLE,
  CONSTRAINT `fk_Bairro_Pegada_Individual`
    FOREIGN KEY (`Pegada_Individual_idPegada_Individual`)
    REFERENCES `DBpegadapessoal`.`Pegada_Individual` (`idPegada_Individual`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
