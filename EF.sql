-- DROP DATABASE siu;
CREATE DATABASE EF;
USE EF;
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;
-- -----------------------------------------------------
-- Table `bodegas`
-- -----------------------------------------------------
CREATE TABLE bodega
(
  Pkid VARCHAR(15),
  tipo_bodega VARCHAR(15),
  nombre VARCHAR(30),
  direccion VARCHAR(65),
  estado VARCHAR(1),
  PRIMARY KEY (Pkid)
 ) ENGINE = InnoDB DEFAULT CHARSET=latin1;