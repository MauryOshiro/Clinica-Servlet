-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clinica_cristiano
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `clinica_cristiano` ;

-- -----------------------------------------------------
-- Schema clinica_cristiano
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinica_cristiano` DEFAULT CHARACTER SET utf8 ;
USE `clinica_cristiano` ;

-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Usuario` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Usuario` (
  `id` SMALLINT(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(25) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `ativo` TINYINT NOT NULL,
  `tipoUsuario` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Modulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Modulo` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Modulo` (
  `id` SMALLINT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nomeModulo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Modulo_X_tb_Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Modulo_X_tb_Usuario` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Modulo_X_tb_Usuario` (
  `tb_Modulo_id` SMALLINT(3) UNSIGNED NOT NULL,
  `tb_Usuario_id` SMALLINT(4) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Modulo_id`, `tb_Usuario_id`),
  INDEX `fk_tb_Modulo_has_tb_Usuario_tb_Usuario1_idx` (`tb_Usuario_id` ASC),
  INDEX `fk_tb_Modulo_has_tb_Usuario_tb_Modulo_idx` (`tb_Modulo_id` ASC),
  CONSTRAINT `fk_tb_Modulo_has_tb_Usuario_tb_Modulo`
    FOREIGN KEY (`tb_Modulo_id`)
    REFERENCES `clinica_cristiano`.`tb_Modulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Modulo_has_tb_Usuario_tb_Usuario1`
    FOREIGN KEY (`tb_Usuario_id`)
    REFERENCES `clinica_cristiano`.`tb_Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Cargo` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Cargo` (
  `id` SMALLINT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ContatoPessoaFisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ContatoPessoaFisica` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ContatoPessoaFisica` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dddTelefonePrincipal` TINYINT(2) UNSIGNED NULL,
  `telefonePrincipal` INT UNSIGNED NULL,
  `dddTelefoneSecundario` TINYINT(2) UNSIGNED NULL,
  `telefoneSecundario` INT UNSIGNED NULL,
  `dddCelularPrincipal` TINYINT(2) UNSIGNED NULL,
  `celularPrincipal` INT UNSIGNED NULL,
  `dddCelularSecundario` TINYINT(2) UNSIGNED NULL,
  `celularSecundario` INT UNSIGNED NULL,
  `email` VARCHAR(80) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Endereco` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Endereco` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tipoVia` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(80) NOT NULL,
  `numero` VARCHAR(8) NOT NULL,
  `complemento` VARCHAR(100) NOT NULL,
  `cep` VARCHAR(9) NOT NULL,
  `bairro` VARCHAR(80) NOT NULL,
  `cidade` VARCHAR(80) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_PessoaFisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_PessoaFisica` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_PessoaFisica` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `cpf` BIGINT(11) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `observacao` VARCHAR(500) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `nivelEscolaridade` VARCHAR(45) NOT NULL,
  `idade` TINYINT(3) UNSIGNED NOT NULL,
  `tb_ContatoPessoaFisica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_Endereco_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_PessoaFisica_tb_ContatoPessoaFisica1_idx` (`tb_ContatoPessoaFisica_id` ASC),
  INDEX `fk_tb_PessoaFisica_tb_Endereco1_idx` (`tb_Endereco_id` ASC),
  INDEX `indiceCpf` (`cpf` ASC),
  INDEX `indiceDataNascimento` (`dataNascimento` ASC),
  CONSTRAINT `fk_tb_PessoaFisica_tb_ContatoPessoaFisica1`
    FOREIGN KEY (`tb_ContatoPessoaFisica_id`)
    REFERENCES `clinica_cristiano`.`tb_ContatoPessoaFisica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_PessoaFisica_tb_Endereco1`
    FOREIGN KEY (`tb_Endereco_id`)
    REFERENCES `clinica_cristiano`.`tb_Endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Funcionario` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Funcionario` (
  `id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `departamento` VARCHAR(80) NOT NULL,
  `dataAdmissao` DATE NOT NULL,
  `ativo` TINYINT NOT NULL,
  `tb_Cargo_id` SMALLINT(3) UNSIGNED NOT NULL,
  `tb_PessoaFisica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_Usuario_id` SMALLINT(4) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Funcionario_tb_Cargo1_idx` (`tb_Cargo_id` ASC),
  INDEX `fk_tb_Funcionario_tb_PessoaFisica1_idx` (`tb_PessoaFisica_id` ASC),
  INDEX `fk_tb_Funcionario_tb_Usuario1_idx` (`tb_Usuario_id` ASC),
  CONSTRAINT `fk_tb_Funcionario_tb_Cargo1`
    FOREIGN KEY (`tb_Cargo_id`)
    REFERENCES `clinica_cristiano`.`tb_Cargo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Funcionario_tb_PessoaFisica1`
    FOREIGN KEY (`tb_PessoaFisica_id`)
    REFERENCES `clinica_cristiano`.`tb_PessoaFisica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Funcionario_tb_Usuario1`
    FOREIGN KEY (`tb_Usuario_id`)
    REFERENCES `clinica_cristiano`.`tb_Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Profissional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Profissional` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Profissional` (
  `id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `crp` VARCHAR(45) NOT NULL,
  `tb_Funcionario_id` SMALLINT(5) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Profissional_tb_Funcionario1_idx` (`tb_Funcionario_id` ASC),
  CONSTRAINT `fk_tb_Profissional_tb_Funcionario1`
    FOREIGN KEY (`tb_Funcionario_id`)
    REFERENCES `clinica_cristiano`.`tb_Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_PessoaJuridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_PessoaJuridica` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_PessoaJuridica` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cnpj` BIGINT(14) UNSIGNED NULL,
  `razaoSocial` VARCHAR(100) NOT NULL,
  `nomeFantasia` VARCHAR(100) NOT NULL,
  `ie` VARCHAR(45) NULL,
  `inscricaoMunicipal` VARCHAR(45) NULL,
  `tb_Endereco_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_PessoaJuridica_tb_Endereco1_idx` (`tb_Endereco_id` ASC),
  CONSTRAINT `fk_tb_PessoaJuridica_tb_Endereco1`
    FOREIGN KEY (`tb_Endereco_id`)
    REFERENCES `clinica_cristiano`.`tb_Endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_EmpresaParceira`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_EmpresaParceira` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_EmpresaParceira` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `dataInicioParceria` DATE NOT NULL,
  `ativo` TINYINT NOT NULL,
  `observacao` VARCHAR(500) NOT NULL,
  `tb_PessoaJuridica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_EmpresaParceira_tb_PessoaJuridica1_idx` (`tb_PessoaJuridica_id` ASC),
  CONSTRAINT `fk_tb_EmpresaParceira_tb_PessoaJuridica1`
    FOREIGN KEY (`tb_PessoaJuridica_id`)
    REFERENCES `clinica_cristiano`.`tb_PessoaJuridica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ContatoNaEmpresaParceira`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ContatoNaEmpresaParceira` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ContatoNaEmpresaParceira` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `tb_ContatoPessoaFisica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_EmpresaParceira_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `observacao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_ContatoNaPessoaJuridica_tb_ContatoPessoaFisica1_idx` (`tb_ContatoPessoaFisica_id` ASC),
  INDEX `fk_tb_ContatoNaPessoaJuridica_tb_EmpresaParceira1_idx` (`tb_EmpresaParceira_id` ASC),
  CONSTRAINT `fk_tb_ContatoNaPessoaJuridica_tb_ContatoPessoaFisica1`
    FOREIGN KEY (`tb_ContatoPessoaFisica_id`)
    REFERENCES `clinica_cristiano`.`tb_ContatoPessoaFisica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_ContatoNaPessoaJuridica_tb_EmpresaParceira1`
    FOREIGN KEY (`tb_EmpresaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_EmpresaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_FuncionarioEmpresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_FuncionarioEmpresa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_FuncionarioEmpresa` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tb_PessoaFisica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_EmpresaParceira_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `funcao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_FuncionarioEmpresa_tb_PessoaFisica1_idx` (`tb_PessoaFisica_id` ASC),
  INDEX `fk_tb_FuncionarioEmpresa_tb_EmpresaParceira1_idx` (`tb_EmpresaParceira_id` ASC),
  CONSTRAINT `fk_tb_FuncionarioEmpresa_tb_PessoaFisica1`
    FOREIGN KEY (`tb_PessoaFisica_id`)
    REFERENCES `clinica_cristiano`.`tb_PessoaFisica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_FuncionarioEmpresa_tb_EmpresaParceira1`
    FOREIGN KEY (`tb_EmpresaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_EmpresaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Exame` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Exame` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `objetivo` TEXT NOT NULL,
  `concluido` TINYINT NOT NULL,
  `cancelado` TINYINT NOT NULL,
  `nomeExame` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_LaudoDeAvaliacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_LaudoDeAvaliacao` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_LaudoDeAvaliacao` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tb_FuncionarioEmpresa_id` INT UNSIGNED NOT NULL,
  `laudo` TEXT NOT NULL,
  `dataEmissao` DATE NOT NULL,
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  `finalizado` TINYINT NOT NULL,
  `cancelado` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_LaudoDeAvaliacao_tb_FuncionarioEmpresa1_idx` (`tb_FuncionarioEmpresa_id` ASC),
  INDEX `fk_tb_LaudoDeAvaliacao_tb_Exame1_idx` (`tb_Exame_id` ASC),
  CONSTRAINT `fk_tb_LaudoDeAvaliacao_tb_FuncionarioEmpresa1`
    FOREIGN KEY (`tb_FuncionarioEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_FuncionarioEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_LaudoDeAvaliacao_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_UnidadeDaEmpresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_UnidadeDaEmpresa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_UnidadeDaEmpresa` (
  `id` TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(250) NOT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_horarioFuncionamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_horarioFuncionamento` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_horarioFuncionamento` (
  `id` SMALLINT NOT NULL,
  `horario` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_AgendaCompromisso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_AgendaCompromisso` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_AgendaCompromisso` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `hora` SMALLINT NOT NULL,
  `tipo` VARCHAR(100) NOT NULL,
  `tb_Profissional_id` SMALLINT(5) UNSIGNED NOT NULL,
  `ativo` TINYINT NOT NULL,
  `tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NOT NULL,
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `hora`),
  INDEX `fk_tb_Agenda_tb_Profissional1_idx` (`tb_Profissional_id` ASC),
  INDEX `fk_tb_AgendaCompromisso_tb_UnidadeDaEmpresa1_idx` (`tb_UnidadeDaEmpresa_id` ASC),
  INDEX `fk_tb_AgendaCompromisso_tb_horarioFuncionamento1_idx` (`hora` ASC),
  INDEX `fk_tb_AgendaCompromisso_tb_Exame1_idx` (`tb_Exame_id` ASC),
  CONSTRAINT `fk_tb_Agenda_tb_Profissional1`
    FOREIGN KEY (`tb_Profissional_id`)
    REFERENCES `clinica_cristiano`.`tb_Profissional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaCompromisso_tb_UnidadeDaEmpresa1`
    FOREIGN KEY (`tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaCompromisso_tb_horarioFuncionamento1`
    FOREIGN KEY (`hora`)
    REFERENCES `clinica_cristiano`.`tb_horarioFuncionamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaCompromisso_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ClinicaParceira`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ClinicaParceira` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ClinicaParceira` (
  `id` MEDIUMINT(8) NOT NULL AUTO_INCREMENT,
  `observacao` VARCHAR(500) NOT NULL,
  `dataInicioParceria` DATE NOT NULL,
  `ativo` TINYINT NOT NULL,
  `tb_PessoaJuridica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_ClinicaParceira_tb_PessoaJuridica1_idx` (`tb_PessoaJuridica_id` ASC),
  CONSTRAINT `fk_tb_ClinicaParceira_tb_PessoaJuridica1`
    FOREIGN KEY (`tb_PessoaJuridica_id`)
    REFERENCES `clinica_cristiano`.`tb_PessoaJuridica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Paciente` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Paciente` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tb_PessoaFisica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `conveniado` TINYINT NOT NULL,
  `ativo` TINYINT NOT NULL,
  `prontuario` TEXT NOT NULL,
  `tb_Profissional_id` SMALLINT(5) UNSIGNED NULL,
  `tb_ClinicaParceira_id` MEDIUMINT(8) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Paciente_tb_PessoaFisica1_idx` (`tb_PessoaFisica_id` ASC),
  INDEX `fk_tb_Paciente_tb_Profissional1_idx` (`tb_Profissional_id` ASC),
  INDEX `fk_tb_Paciente_tb_ClinicaParceira1_idx` (`tb_ClinicaParceira_id` ASC),
  CONSTRAINT `fk_tb_Paciente_tb_PessoaFisica1`
    FOREIGN KEY (`tb_PessoaFisica_id`)
    REFERENCES `clinica_cristiano`.`tb_PessoaFisica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Paciente_tb_Profissional1`
    FOREIGN KEY (`tb_Profissional_id`)
    REFERENCES `clinica_cristiano`.`tb_Profissional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Paciente_tb_ClinicaParceira1`
    FOREIGN KEY (`tb_ClinicaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_ClinicaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ExameConclusoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ExameConclusoes` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ExameConclusoes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `conclusao` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ExameConclusoes_X_tb_Exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ExameConclusoes_X_tb_Exame` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ExameConclusoes_X_tb_Exame` (
  `tb_ExameConclusoes_id` INT UNSIGNED NOT NULL,
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_ExameConclusoes_id`, `tb_Exame_id`),
  INDEX `fk_tb_ExameConclusoes_has_tb_Exame_tb_Exame1_idx` (`tb_Exame_id` ASC),
  INDEX `fk_tb_ExameConclusoes_has_tb_Exame_tb_ExameConclusoes1_idx` (`tb_ExameConclusoes_id` ASC),
  CONSTRAINT `fk_tb_ExameConclusoes_has_tb_Exame_tb_ExameConclusoes1`
    FOREIGN KEY (`tb_ExameConclusoes_id`)
    REFERENCES `clinica_cristiano`.`tb_ExameConclusoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_ExameConclusoes_has_tb_Exame_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Teste`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Teste` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Teste` (
  `id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` TEXT NOT NULL,
  `finalidade` TEXT NOT NULL,
  `observacao` TEXT NOT NULL,
  `habilitado` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Exame_X_tb_Teste`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Exame_X_tb_Teste` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Exame_X_tb_Teste` (
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  `tb_Teste_id` SMALLINT(5) UNSIGNED NOT NULL,
  `resultado` TEXT NOT NULL,
  `observacao` TEXT NOT NULL,
  `cancelado` TINYINT NOT NULL,
  PRIMARY KEY (`tb_Exame_id`, `tb_Teste_id`),
  INDEX `fk_tb_Exame_has_tb_Teste_tb_Teste1_idx` (`tb_Teste_id` ASC),
  INDEX `fk_tb_Exame_has_tb_Teste_tb_Exame1_idx` (`tb_Exame_id` ASC),
  CONSTRAINT `fk_tb_Exame_has_tb_Teste_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Exame_has_tb_Teste_tb_Teste1`
    FOREIGN KEY (`tb_Teste_id`)
    REFERENCES `clinica_cristiano`.`tb_Teste` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Convenio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Convenio` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Convenio` (
  `id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ativo` TINYINT NOT NULL,
  `tb_PessoaJuridica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Convenio_tb_PessoaJuridica1_idx` (`tb_PessoaJuridica_id` ASC),
  CONSTRAINT `fk_tb_Convenio_tb_PessoaJuridica1`
    FOREIGN KEY (`tb_PessoaJuridica_id`)
    REFERENCES `clinica_cristiano`.`tb_PessoaJuridica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_PacienteConveniado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_PacienteConveniado` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_PacienteConveniado` (
  `tb_Paciente_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_Convenio_id` SMALLINT(5) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Paciente_id`, `tb_Convenio_id`),
  INDEX `fk_tb_PacienteConveniado_tb_Convenio1_idx` (`tb_Convenio_id` ASC),
  CONSTRAINT `fk_tb_PacienteConveniado_tb_Paciente1`
    FOREIGN KEY (`tb_Paciente_id`)
    REFERENCES `clinica_cristiano`.`tb_Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_PacienteConveniado_tb_Convenio1`
    FOREIGN KEY (`tb_Convenio_id`)
    REFERENCES `clinica_cristiano`.`tb_Convenio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Fatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Fatura` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Fatura` (
  `id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `valorTotal` DECIMAL(9,2) UNSIGNED NOT NULL,
  `cancelado` TINYINT NOT NULL,
  `mesReferencia` TINYINT(2) UNSIGNED NOT NULL,
  `faturaPara` VARCHAR(80) NOT NULL,
  `observacao` VARCHAR(500) NOT NULL,
  `quitado` TINYINT NOT NULL,
  `tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `tb_UnidadeDaEmpresa_id`),
  INDEX `fk_tb_Fatura_tb_UnidadeDaEmpresa1_idx` (`tb_UnidadeDaEmpresa_id` ASC),
  CONSTRAINT `fk_tb_Fatura_tb_UnidadeDaEmpresa1`
    FOREIGN KEY (`tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_GuiaConvenio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_GuiaConvenio` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_GuiaConvenio` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `dataPedido` DATE NOT NULL,
  `horarioPedido` TIME NOT NULL,
  `cancelado` TINYINT NOT NULL,
  `tb_Funcionario_id` SMALLINT(5) UNSIGNED NOT NULL,
  `faturado` TINYINT NOT NULL,
  `tb_PacienteConveniado_tb_Paciente_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_PacienteConveniado_tb_Convenio_id` SMALLINT(5) UNSIGNED NOT NULL,
  `tb_Fatura_id` MEDIUMINT(8) UNSIGNED NULL,
  `tb_Fatura_tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_GuiaConvenio_tb_Funcionario1_idx` (`tb_Funcionario_id` ASC),
  INDEX `fk_tb_GuiaConvenio_tb_PacienteConveniado1_idx` (`tb_PacienteConveniado_tb_Paciente_id` ASC, `tb_PacienteConveniado_tb_Convenio_id` ASC),
  INDEX `fk_tb_GuiaConvenio_tb_Fatura1_idx` (`tb_Fatura_id` ASC, `tb_Fatura_tb_UnidadeDaEmpresa_id` ASC),
  CONSTRAINT `fk_tb_GuiaConvenio_tb_Funcionario1`
    FOREIGN KEY (`tb_Funcionario_id`)
    REFERENCES `clinica_cristiano`.`tb_Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_GuiaConvenio_tb_PacienteConveniado1`
    FOREIGN KEY (`tb_PacienteConveniado_tb_Paciente_id` , `tb_PacienteConveniado_tb_Convenio_id`)
    REFERENCES `clinica_cristiano`.`tb_PacienteConveniado` (`tb_Paciente_id` , `tb_Convenio_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_GuiaConvenio_tb_Fatura1`
    FOREIGN KEY (`tb_Fatura_id` , `tb_Fatura_tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_Fatura` (`id` , `tb_UnidadeDaEmpresa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ParcelaFatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ParcelaFatura` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ParcelaFatura` (
  `numeroParcela` TINYINT(3) UNSIGNED NOT NULL,
  `valorParcela` DECIMAL(9,2) UNSIGNED NOT NULL,
  `pago` TINYINT NOT NULL,
  `vencimentoOriginal` DATE NOT NULL,
  `vencimentoReal` DATE NOT NULL,
  `valorDesconto` DECIMAL(9,2) UNSIGNED NOT NULL,
  `valorJuros` DECIMAL(9,2) UNSIGNED NOT NULL,
  `tb_Fatura_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Fatura_id`, `numeroParcela`),
  INDEX `fk_tb_Parcela_Fatura_tb_Fatura1_idx` (`tb_Fatura_id` ASC),
  CONSTRAINT `fk_tb_Parcela_Fatura_tb_Fatura1`
    FOREIGN KEY (`tb_Fatura_id`)
    REFERENCES `clinica_cristiano`.`tb_Fatura` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_PortadorSaldo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_PortadorSaldo` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_PortadorSaldo` (
  `id` MEDIUMINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `saldoDisponivelInicial` DECIMAL(9,2) NOT NULL,
  `saldoBrutoInicial` DECIMAL(9,2) NOT NULL,
  `saldoDisponivelDataConciliacao` DECIMAL(9,2) NOT NULL,
  `saldoBrutoDataConciliacao` DECIMAL(9,2) NOT NULL,
  `saldoDisponivelAtual` DECIMAL(9,2) NOT NULL,
  `saldoBrutoAtual` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Portador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Portador` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Portador` (
  `id` SMALLINT(5) UNSIGNED NOT NULL,
  `tipoPortador` VARCHAR(100) NOT NULL,
  `nomePortador` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `dataConciliacao` DATE NOT NULL,
  `ativo` TINYINT NOT NULL,
  `sequenciaLancamento` MEDIUMINT(8) UNSIGNED NOT NULL,
  `podeTerSaldoNegativo` TINYINT NOT NULL,
  `tb_PortadorSaldo_id` MEDIUMINT(5) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Portador_tb_PortadorSaldo1_idx` (`tb_PortadorSaldo_id` ASC),
  CONSTRAINT `fk_tb_Portador_tb_PortadorSaldo1`
    FOREIGN KEY (`tb_PortadorSaldo_id`)
    REFERENCES `clinica_cristiano`.`tb_PortadorSaldo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Lancamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Lancamento` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Lancamento` (
  `numeroLancamento` INT UNSIGNED NOT NULL,
  `tipoLancamento` VARCHAR(45) NOT NULL,
  `dataLancamento` DATE NOT NULL,
  `valor` DECIMAL(9,2) UNSIGNED NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `observacao` VARCHAR(255) NOT NULL,
  `cancelado` TINYINT NOT NULL,
  `dataPagamento` DATE NOT NULL,
  `meioDePagamento` VARCHAR(255) NOT NULL,
  `tb_Portador_id` SMALLINT(5) UNSIGNED NOT NULL,
  PRIMARY KEY (`numeroLancamento`),
  INDEX `indiceDataLancamento` (`dataLancamento` ASC),
  INDEX `indiceDataPagamento` (`dataPagamento` ASC),
  INDEX `fk_tb_Lancamento_tb_Portador1_idx` (`tb_Portador_id` ASC),
  CONSTRAINT `fk_tb_Lancamento_tb_Portador1`
    FOREIGN KEY (`tb_Portador_id`)
    REFERENCES `clinica_cristiano`.`tb_Portador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_LancamentoCancelado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_LancamentoCancelado` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_LancamentoCancelado` (
  `dataCancelamento` DATE NOT NULL,
  `tb_Lancamento_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Lancamento_id`),
  CONSTRAINT `fk_tb_LancamentoCancelado_tb_Lancamento1`
    FOREIGN KEY (`tb_Lancamento_id`)
    REFERENCES `clinica_cristiano`.`tb_Lancamento` (`numeroLancamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_LancamentoParcelaFatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_LancamentoParcelaFatura` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_LancamentoParcelaFatura` (
  `tb_Lancamento_id` INT UNSIGNED NOT NULL,
  `tb_ParcelaFatura_tb_Fatura_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_ParcelaFatura_numeroParcela` TINYINT(3) UNSIGNED NOT NULL,
  INDEX `fk_tb_LancamentoParcelaFatura_tb_ParcelaFatura1_idx` (`tb_ParcelaFatura_tb_Fatura_id` ASC, `tb_ParcelaFatura_numeroParcela` ASC),
  PRIMARY KEY (`tb_Lancamento_id`),
  CONSTRAINT `fk_tb_LancamentoParcelaFatura_tb_ParcelaFatura1`
    FOREIGN KEY (`tb_ParcelaFatura_tb_Fatura_id` , `tb_ParcelaFatura_numeroParcela`)
    REFERENCES `clinica_cristiano`.`tb_ParcelaFatura` (`tb_Fatura_id` , `numeroParcela`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_LancamentoParcelaFatura_tb_Lancamento1`
    FOREIGN KEY (`tb_Lancamento_id`)
    REFERENCES `clinica_cristiano`.`tb_Lancamento` (`numeroLancamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_TipoDespesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_TipoDespesa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_TipoDespesa` (
  `id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NOT NULL,
  `observacao` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Despesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Despesa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Despesa` (
  `id` MEDIUMINT(8) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NOT NULL,
  `tb_TipoDespesa_id` SMALLINT(5) UNSIGNED NOT NULL,
  `valor` DECIMAL(9,2) UNSIGNED NOT NULL,
  `quitado` TINYINT NOT NULL,
  `qtdParcelas` SMALLINT(5) UNSIGNED NOT NULL,
  `cancelado` TINYINT NOT NULL,
  `tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `tb_UnidadeDaEmpresa_id`),
  INDEX `fk_tb_Despesa_tb_TipoDespesa1_idx` (`tb_TipoDespesa_id` ASC),
  INDEX `fk_tb_Despesa_tb_UnidadeDaEmpresa1_idx` (`tb_UnidadeDaEmpresa_id` ASC),
  CONSTRAINT `fk_tb_Despesa_tb_TipoDespesa1`
    FOREIGN KEY (`tb_TipoDespesa_id`)
    REFERENCES `clinica_cristiano`.`tb_TipoDespesa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Despesa_tb_UnidadeDaEmpresa1`
    FOREIGN KEY (`tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ParcelaDespesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ParcelaDespesa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ParcelaDespesa` (
  `numeroParcela` TINYINT(3) UNSIGNED NOT NULL,
  `valorParcela` DECIMAL(9,2) UNSIGNED NOT NULL,
  `pago` TINYINT UNSIGNED NOT NULL,
  `vencimentoOriginal` DATE NOT NULL,
  `vencimentoReal` DATE NOT NULL,
  `valorDesconto` DECIMAL(9,2) UNSIGNED NOT NULL,
  `valorJuros` DECIMAL(9,2) UNSIGNED NOT NULL,
  `tb_Despesa_id` MEDIUMINT(8) NOT NULL,
  PRIMARY KEY (`tb_Despesa_id`, `numeroParcela`),
  INDEX `fk_tb_ParcelaDespesa_tb_Despesa1_idx` (`tb_Despesa_id` ASC),
  CONSTRAINT `fk_tb_ParcelaDespesa_tb_Despesa1`
    FOREIGN KEY (`tb_Despesa_id`)
    REFERENCES `clinica_cristiano`.`tb_Despesa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ParcelaFaturaPaga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ParcelaFaturaPaga` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ParcelaFaturaPaga` (
  `dataPagamento` DATE NOT NULL,
  `tb_ParcelaFatura_tb_Fatura_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `tb_ParcelaFatura_numeroParcela` TINYINT(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_ParcelaFatura_tb_Fatura_id`, `tb_ParcelaFatura_numeroParcela`),
  CONSTRAINT `fk_tb_ParcelaFaturaPaga_tb_ParcelaFatura1`
    FOREIGN KEY (`tb_ParcelaFatura_tb_Fatura_id` , `tb_ParcelaFatura_numeroParcela`)
    REFERENCES `clinica_cristiano`.`tb_ParcelaFatura` (`tb_Fatura_id` , `numeroParcela`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ParcelaDespesaPaga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ParcelaDespesaPaga` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ParcelaDespesaPaga` (
  `dataPagamento` DATE NOT NULL,
  `tb_ParcelaDespesa_tb_Despesa_id` MEDIUMINT(8) NOT NULL,
  `tb_ParcelaDespesa_numeroParcela` TINYINT(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_ParcelaDespesa_tb_Despesa_id`, `tb_ParcelaDespesa_numeroParcela`),
  CONSTRAINT `fk_tb_ParcelaDespesaPaga_tb_ParcelaDespesa1`
    FOREIGN KEY (`tb_ParcelaDespesa_tb_Despesa_id` , `tb_ParcelaDespesa_numeroParcela`)
    REFERENCES `clinica_cristiano`.`tb_ParcelaDespesa` (`tb_Despesa_id` , `numeroParcela`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_LancamentoParcelaDespesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_LancamentoParcelaDespesa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_LancamentoParcelaDespesa` (
  `tb_Lancamento_id` INT UNSIGNED NOT NULL,
  `tb_ParcelaDespesa_tb_Despesa_id` MEDIUMINT(8) NOT NULL,
  `tb_ParcelaDespesa_numeroParcela` TINYINT(3) UNSIGNED NOT NULL,
  INDEX `fk_tb_LancamentoParcelaDespesa_tb_ParcelaDespesa1_idx` (`tb_ParcelaDespesa_tb_Despesa_id` ASC, `tb_ParcelaDespesa_numeroParcela` ASC),
  PRIMARY KEY (`tb_Lancamento_id`),
  CONSTRAINT `fk_tb_LancamentoParcelaDespesa_tb_ParcelaDespesa1`
    FOREIGN KEY (`tb_ParcelaDespesa_tb_Despesa_id` , `tb_ParcelaDespesa_numeroParcela`)
    REFERENCES `clinica_cristiano`.`tb_ParcelaDespesa` (`tb_Despesa_id` , `numeroParcela`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_LancamentoParcelaDespesa_tb_Lancamento1`
    FOREIGN KEY (`tb_Lancamento_id`)
    REFERENCES `clinica_cristiano`.`tb_Lancamento` (`numeroLancamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_LogLogin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_LogLogin` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_LogLogin` (
  `data` DATE NOT NULL,
  `horario` TIME NOT NULL,
  `tb_Funcionario_id` SMALLINT(5) UNSIGNED NOT NULL,
  INDEX `fk_tb_LogLogin_tb_Funcionario1_idx` (`tb_Funcionario_id` ASC),
  INDEX `indiceData` (`data` ASC),
  CONSTRAINT `fk_tb_LogLogin_tb_Funcionario1`
    FOREIGN KEY (`tb_Funcionario_id`)
    REFERENCES `clinica_cristiano`.`tb_Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_FuncionarioDemitido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_FuncionarioDemitido` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_FuncionarioDemitido` (
  `dataDemissao` DATE NOT NULL,
  `tb_Funcionario_id` SMALLINT(5) UNSIGNED NOT NULL,
  INDEX `fk_tb_FuncionarioDemitido_tb_Funcionario1_idx` (`tb_Funcionario_id` ASC),
  CONSTRAINT `fk_tb_FuncionarioDemitido_tb_Funcionario1`
    FOREIGN KEY (`tb_Funcionario_id`)
    REFERENCES `clinica_cristiano`.`tb_Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_LogAlteracao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_LogAlteracao` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_LogAlteracao` (
  `data` DATE NOT NULL,
  `horario` TIME NOT NULL,
  `tb_Modulo_id` SMALLINT(3) UNSIGNED NOT NULL,
  `nomeTela` VARCHAR(255) NOT NULL,
  `tipo` VARCHAR(255) NOT NULL,
  `identificacaoRegistro` INT UNSIGNED NOT NULL,
  `informacaoAnterior` TEXT NOT NULL,
  `tb_Funcionario_id` SMALLINT(5) UNSIGNED NOT NULL,
  INDEX `fk_tb_LogAlteracao_tb_Modulo1_idx` (`tb_Modulo_id` ASC),
  INDEX `fk_tb_LogAlteracao_tb_Funcionario1_idx` (`tb_Funcionario_id` ASC),
  INDEX `indiceData` (`data` ASC),
  CONSTRAINT `fk_tb_LogAlteracao_tb_Modulo1`
    FOREIGN KEY (`tb_Modulo_id`)
    REFERENCES `clinica_cristiano`.`tb_Modulo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_LogAlteracao_tb_Funcionario1`
    FOREIGN KEY (`tb_Funcionario_id`)
    REFERENCES `clinica_cristiano`.`tb_Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Cheque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Cheque` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Cheque` (
  `id` SMALLINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `baixado` TINYINT NOT NULL,
  `sustado` TINYINT NOT NULL,
  `numero` SMALLINT(5) UNSIGNED NOT NULL,
  `tb_LancamentoParcelaDespesa_tb_Lancamento_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_Cheque_tb_LancamentoParcelaDespesa1_idx` (`tb_LancamentoParcelaDespesa_tb_Lancamento_id` ASC),
  CONSTRAINT `fk_tb_Cheque_tb_LancamentoParcelaDespesa1`
    FOREIGN KEY (`tb_LancamentoParcelaDespesa_tb_Lancamento_id`)
    REFERENCES `clinica_cristiano`.`tb_LancamentoParcelaDespesa` (`tb_Lancamento_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ChequeBaixado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ChequeBaixado` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ChequeBaixado` (
  `dataBaixa` DATE NOT NULL,
  `tb_Cheque_id` SMALLINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Cheque_id`),
  CONSTRAINT `fk_tb_ChequeBaixado_tb_Cheque1`
    FOREIGN KEY (`tb_Cheque_id`)
    REFERENCES `clinica_cristiano`.`tb_Cheque` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Funcionario_X_tb_UnidadeDaEmpresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Funcionario_X_tb_UnidadeDaEmpresa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Funcionario_X_tb_UnidadeDaEmpresa` (
  `tb_Funcionario_id` SMALLINT(5) UNSIGNED NOT NULL,
  `tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Funcionario_id`, `tb_UnidadeDaEmpresa_id`),
  INDEX `fk_tb_Funcionario_has_tb_UnidadeDaEmpresa_tb_UnidadeDaEmpre_idx` (`tb_UnidadeDaEmpresa_id` ASC),
  INDEX `fk_tb_Funcionario_has_tb_UnidadeDaEmpresa_tb_Funcionario1_idx` (`tb_Funcionario_id` ASC),
  CONSTRAINT `fk_tb_Funcionario_has_tb_UnidadeDaEmpresa_tb_Funcionario1`
    FOREIGN KEY (`tb_Funcionario_id`)
    REFERENCES `clinica_cristiano`.`tb_Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Funcionario_has_tb_UnidadeDaEmpresa_tb_UnidadeDaEmpresa1`
    FOREIGN KEY (`tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Portador_X_tb_UnidadeDaEmpresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Portador_X_tb_UnidadeDaEmpresa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Portador_X_tb_UnidadeDaEmpresa` (
  `tb_Portador_id` SMALLINT(5) UNSIGNED NOT NULL,
  `tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_Portador_id`, `tb_UnidadeDaEmpresa_id`),
  INDEX `fk_tb_Portador_has_tb_UnidadeDaEmpresa_tb_UnidadeDaEmpresa1_idx` (`tb_UnidadeDaEmpresa_id` ASC),
  INDEX `fk_tb_Portador_has_tb_UnidadeDaEmpresa_tb_Portador1_idx` (`tb_Portador_id` ASC),
  CONSTRAINT `fk_tb_Portador_has_tb_UnidadeDaEmpresa_tb_Portador1`
    FOREIGN KEY (`tb_Portador_id`)
    REFERENCES `clinica_cristiano`.`tb_Portador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Portador_has_tb_UnidadeDaEmpresa_tb_UnidadeDaEmpresa1`
    FOREIGN KEY (`tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_AgendaPaciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_AgendaPaciente` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_AgendaPaciente` (
  `tb_Paciente_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  `geradoGuia` TINYINT NOT NULL,
  `faturado` TINYINT NOT NULL,
  `presenca` TINYINT NOT NULL,
  `tb_AgendaCompromisso_id` INT UNSIGNED NOT NULL,
  `tb_Fatura_id` MEDIUMINT(8) UNSIGNED NULL,
  `tb_Fatura_tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NULL,
  PRIMARY KEY (`tb_Paciente_id`, `tb_AgendaCompromisso_id`),
  INDEX `fk_tb_AgendaCompromisso_has_tb_Paciente_tb_Paciente1_idx` (`tb_Paciente_id` ASC),
  INDEX `fk_tb_AgendaPaciente_tb_AgendaCompromisso1_idx` (`tb_AgendaCompromisso_id` ASC),
  INDEX `fk_tb_AgendaPaciente_tb_Fatura1_idx` (`tb_Fatura_id` ASC, `tb_Fatura_tb_UnidadeDaEmpresa_id` ASC),
  CONSTRAINT `fk_tb_AgendaCompromisso_has_tb_Paciente_tb_Paciente1`
    FOREIGN KEY (`tb_Paciente_id`)
    REFERENCES `clinica_cristiano`.`tb_Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaPaciente_tb_AgendaCompromisso1`
    FOREIGN KEY (`tb_AgendaCompromisso_id`)
    REFERENCES `clinica_cristiano`.`tb_AgendaCompromisso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaPaciente_tb_Fatura1`
    FOREIGN KEY (`tb_Fatura_id` , `tb_Fatura_tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_Fatura` (`id` , `tb_UnidadeDaEmpresa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_AgendaFuncionarioEmpresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_AgendaFuncionarioEmpresa` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_AgendaFuncionarioEmpresa` (
  `tb_AgendaCompromisso_id` INT UNSIGNED NOT NULL,
  `tb_FuncionarioEmpresa_id` INT UNSIGNED NOT NULL,
  `faturado` TINYINT NOT NULL,
  `presenca` TINYINT NOT NULL,
  `tb_Fatura_id` MEDIUMINT(8) UNSIGNED NULL,
  `tb_Fatura_tb_UnidadeDaEmpresa_id` TINYINT(3) UNSIGNED NULL,
  PRIMARY KEY (`tb_AgendaCompromisso_id`, `tb_FuncionarioEmpresa_id`),
  INDEX `fk_tb_AgendaCompromisso_has_tb_FuncionarioEmpresa_tb_Funcio_idx` (`tb_FuncionarioEmpresa_id` ASC),
  INDEX `fk_tb_AgendaCompromisso_has_tb_FuncionarioEmpresa_tb_Agenda_idx` (`tb_AgendaCompromisso_id` ASC),
  INDEX `fk_tb_AgendaFuncionarioEmpresa_tb_Fatura1_idx` (`tb_Fatura_id` ASC, `tb_Fatura_tb_UnidadeDaEmpresa_id` ASC),
  CONSTRAINT `fk_tb_AgendaCompromisso_has_tb_FuncionarioEmpresa_tb_AgendaCo1`
    FOREIGN KEY (`tb_AgendaCompromisso_id`)
    REFERENCES `clinica_cristiano`.`tb_AgendaCompromisso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaCompromisso_has_tb_FuncionarioEmpresa_tb_Funciona1`
    FOREIGN KEY (`tb_FuncionarioEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_FuncionarioEmpresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_AgendaFuncionarioEmpresa_tb_Fatura1`
    FOREIGN KEY (`tb_Fatura_id` , `tb_Fatura_tb_UnidadeDaEmpresa_id`)
    REFERENCES `clinica_cristiano`.`tb_Fatura` (`id` , `tb_UnidadeDaEmpresa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ClinicaParceira_X_tb_Paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ClinicaParceira_X_tb_Paciente` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ClinicaParceira_X_tb_Paciente` (
  `tb_ClinicaParceira_id` MEDIUMINT(8) NOT NULL,
  `tb_Paciente_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`tb_ClinicaParceira_id`, `tb_Paciente_id`),
  INDEX `fk_tb_ClinicaParceira_has_tb_Paciente_tb_Paciente1_idx` (`tb_Paciente_id` ASC),
  INDEX `fk_tb_ClinicaParceira_has_tb_Paciente_tb_ClinicaParceira1_idx` (`tb_ClinicaParceira_id` ASC),
  CONSTRAINT `fk_tb_ClinicaParceira_has_tb_Paciente_tb_ClinicaParceira1`
    FOREIGN KEY (`tb_ClinicaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_ClinicaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_ClinicaParceira_has_tb_Paciente_tb_Paciente1`
    FOREIGN KEY (`tb_Paciente_id`)
    REFERENCES `clinica_cristiano`.`tb_Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_ContatoNaClinicaParceira`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_ContatoNaClinicaParceira` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_ContatoNaClinicaParceira` (
  `id` MEDIUMINT(8) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `tb_ClinicaParceira_id` MEDIUMINT(8) NOT NULL,
  `tb_ContatoPessoaFisica_id` MEDIUMINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_ContatoNaClinicaParceira_tb_ClinicaParceira1_idx` (`tb_ClinicaParceira_id` ASC),
  INDEX `fk_tb_ContatoNaClinicaParceira_tb_ContatoPessoaFisica1_idx` (`tb_ContatoPessoaFisica_id` ASC),
  CONSTRAINT `fk_tb_ContatoNaClinicaParceira_tb_ClinicaParceira1`
    FOREIGN KEY (`tb_ClinicaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_ClinicaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_ContatoNaClinicaParceira_tb_ContatoPessoaFisica1`
    FOREIGN KEY (`tb_ContatoPessoaFisica_id`)
    REFERENCES `clinica_cristiano`.`tb_ContatoPessoaFisica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Preco_Exame_X_EmpresaParceira`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Preco_Exame_X_EmpresaParceira` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Preco_Exame_X_EmpresaParceira` (
  `tb_ClinicaParceira_id` MEDIUMINT(8) NOT NULL,
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  `preco` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`tb_ClinicaParceira_id`, `tb_Exame_id`),
  INDEX `fk_tb_ClinicaParceira_has_tb_Exame_tb_Exame1_idx` (`tb_Exame_id` ASC),
  INDEX `fk_tb_ClinicaParceira_has_tb_Exame_tb_ClinicaParceira1_idx` (`tb_ClinicaParceira_id` ASC),
  CONSTRAINT `fk_tb_ClinicaParceira_has_tb_Exame_tb_ClinicaParceira1`
    FOREIGN KEY (`tb_ClinicaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_ClinicaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_ClinicaParceira_has_tb_Exame_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Preco_Exame_X_EmpresaParceira`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Preco_Exame_X_EmpresaParceira` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Preco_Exame_X_EmpresaParceira` (
  `tb_ClinicaParceira_id` MEDIUMINT(8) NOT NULL,
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  `preco` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`tb_ClinicaParceira_id`, `tb_Exame_id`),
  INDEX `fk_tb_ClinicaParceira_has_tb_Exame_tb_Exame1_idx` (`tb_Exame_id` ASC),
  INDEX `fk_tb_ClinicaParceira_has_tb_Exame_tb_ClinicaParceira1_idx` (`tb_ClinicaParceira_id` ASC),
  CONSTRAINT `fk_tb_ClinicaParceira_has_tb_Exame_tb_ClinicaParceira1`
    FOREIGN KEY (`tb_ClinicaParceira_id`)
    REFERENCES `clinica_cristiano`.`tb_ClinicaParceira` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_ClinicaParceira_has_tb_Exame_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Preco_Exame_X_Convenio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Preco_Exame_X_Convenio` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Preco_Exame_X_Convenio` (
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  `tb_Convenio_id` SMALLINT(5) UNSIGNED NOT NULL,
  `preco` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`tb_Exame_id`, `tb_Convenio_id`),
  INDEX `fk_tb_Exame_has_tb_Convenio_tb_Convenio1_idx` (`tb_Convenio_id` ASC),
  INDEX `fk_tb_Exame_has_tb_Convenio_tb_Exame1_idx` (`tb_Exame_id` ASC),
  CONSTRAINT `fk_tb_Exame_has_tb_Convenio_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_Exame_has_tb_Convenio_tb_Convenio1`
    FOREIGN KEY (`tb_Convenio_id`)
    REFERENCES `clinica_cristiano`.`tb_Convenio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica_cristiano`.`tb_Preco_Exame_Particular`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica_cristiano`.`tb_Preco_Exame_Particular` ;

CREATE TABLE IF NOT EXISTS `clinica_cristiano`.`tb_Preco_Exame_Particular` (
  `id` MEDIUMINT(7) NOT NULL,
  `tb_Exame_id` INT UNSIGNED NOT NULL,
  `preco` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`, `tb_Exame_id`),
  INDEX `fk_tb_Preco_Exame_Particular_tb_Exame1_idx` (`tb_Exame_id` ASC),
  CONSTRAINT `fk_tb_Preco_Exame_Particular_tb_Exame1`
    FOREIGN KEY (`tb_Exame_id`)
    REFERENCES `clinica_cristiano`.`tb_Exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Usuario` (`id`, `login`, `senha`, `ativo`, `tipoUsuario`) VALUES (1, 'adm', '', 1, 'Supervisor');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Modulo`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Modulo` (`id`, `nomeModulo`) VALUES (1, 'Atendimento');
INSERT INTO `clinica_cristiano`.`tb_Modulo` (`id`, `nomeModulo`) VALUES (2, 'Financeiro');
INSERT INTO `clinica_cristiano`.`tb_Modulo` (`id`, `nomeModulo`) VALUES (3, 'Sistema');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Modulo_X_tb_Usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Modulo_X_tb_Usuario` (`tb_Modulo_id`, `tb_Usuario_id`) VALUES (1, 1);
INSERT INTO `clinica_cristiano`.`tb_Modulo_X_tb_Usuario` (`tb_Modulo_id`, `tb_Usuario_id`) VALUES (2, 1);
INSERT INTO `clinica_cristiano`.`tb_Modulo_X_tb_Usuario` (`tb_Modulo_id`, `tb_Usuario_id`) VALUES (3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Cargo`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Cargo` (`id`, `nome`) VALUES (1, 'Supervisor');
INSERT INTO `clinica_cristiano`.`tb_Cargo` (`id`, `nome`) VALUES (2, 'Psicólogo');
INSERT INTO `clinica_cristiano`.`tb_Cargo` (`id`, `nome`) VALUES (3, 'Nutricionista');
INSERT INTO `clinica_cristiano`.`tb_Cargo` (`id`, `nome`) VALUES (4, 'Secretária');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_ContatoPessoaFisica`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_ContatoPessoaFisica` (`id`, `dddTelefonePrincipal`, `telefonePrincipal`, `dddTelefoneSecundario`, `telefoneSecundario`, `dddCelularPrincipal`, `celularPrincipal`, `dddCelularSecundario`, `celularSecundario`, `email`) VALUES (1, 11, 44723181, NULL, NULL, 11, 983229294, NULL, NULL, 'mauryoshiro@gmail.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Endereco`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Endereco` (`id`, `tipoVia`, `logradouro`, `numero`, `complemento`, `cep`, `bairro`, `cidade`, `uf`) VALUES (1, 'Rua', 'Bolívia', '515', 'APTO 02', '09280-290', 'Parque das Nações', 'Santo André', 'SP');
INSERT INTO `clinica_cristiano`.`tb_Endereco` (`id`, `tipoVia`, `logradouro`, `numero`, `complemento`, `cep`, `bairro`, `cidade`, `uf`) VALUES (2, 'Rua', 'Madagascar', '123', 'Nenhum', '09260-090', 'Paraque Oratório', 'Santo André', 'SP');
INSERT INTO `clinica_cristiano`.`tb_Endereco` (`id`, `tipoVia`, `logradouro`, `numero`, `complemento`, `cep`, `bairro`, `cidade`, `uf`) VALUES (3, 'Rua', 'Colúmbia', '200', 'Nenhum', '09291-000', 'Parque das Nações', 'Santo André', 'SP');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_PessoaFisica`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_PessoaFisica` (`id`, `nome`, `sobrenome`, `rg`, `cpf`, `dataNascimento`, `observacao`, `sexo`, `nivelEscolaridade`, `idade`, `tb_ContatoPessoaFisica_id`, `tb_Endereco_id`) VALUES (1, 'Maury Mitsuyuki', 'Oshiro', '43.036.237-7', 40246606838, '1994-01-27', 'nada', 'M', 'Superior Complelto', 24, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Funcionario`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Funcionario` (`id`, `departamento`, `dataAdmissao`, `ativo`, `tb_Cargo_id`, `tb_PessoaFisica_id`, `tb_Usuario_id`) VALUES (1, 'Geral', '2018-07-30', 1, 1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Profissional`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Profissional` (`id`, `crp`, `tb_Funcionario_id`) VALUES (1, '12345', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_PessoaJuridica`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (1, 78445152000195, 'João e Lima LTDA', 'Amil', '418.112.221.057', '0', 2);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (2, 21313318000100, 'Keith e CIA SA', 'Santa Helena', '252.771.134.270', '0', 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (3, NULL, 'Mednet', 'Mednet', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (4, NULL, 'M SO', 'M SO', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (5, NULL, 'SETRA', 'SETRA', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (6, NULL, 'UITAPREU', 'UITAPREU', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (7, NULL, 'Intermédica/Notredame', 'Intermédica/Notredame', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (8, NULL, 'Ameplan', 'Ameplan', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (9, NULL, 'Saúde Caixa', 'Saúde Caixa', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (10, NULL, 'Bio Vida Saúde', 'Bio Vida Saúde', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (11, NULL, 'Bio Saúde', 'Bio Saúde', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (12, NULL, 'Transmontanoe', 'Transmontano', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (13, NULL, 'Greenline', 'Greenline', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (14, NULL, 'Allianz Saúde', 'Allianz Saúde', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (15, NULL, 'Unihosp', 'Unihosp', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (16, NULL, 'Cruz Azul Saúde', 'Cruz Azul Saúde', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (17, NULL, 'Bradesco Saúde', 'Bradesco Saúde', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (18, NULL, 'Medservice', 'Medservice', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (19, NULL, 'Sulamérica', 'Sulamérica', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (20, NULL, 'Amil', 'Amil', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (21, NULL, 'Next Saúde', 'Next Saúde', NULL, NULL, 3);
INSERT INTO `clinica_cristiano`.`tb_PessoaJuridica` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `ie`, `inscricaoMunicipal`, `tb_Endereco_id`) VALUES (22, NULL, 'Porto Saúde', 'Porto Saúde', NULL, NULL, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_UnidadeDaEmpresa`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`, `descricao`, `ativo`) VALUES (1, 'Matriz', 1);
INSERT INTO `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`, `descricao`, `ativo`) VALUES (2, 'Av. Portugal', 1);
INSERT INTO `clinica_cristiano`.`tb_UnidadeDaEmpresa` (`id`, `descricao`, `ativo`) VALUES (3, 'São Bernardo', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_horarioFuncionamento`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (1, '07:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (2, '07:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (3, '08:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (4, '08:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (5, '09:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (6, '09:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (7, '10:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (8, '10:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (9, '11:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (10, '11:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (11, '12:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (12, '12:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (13, '13:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (14, '13:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (15, '14:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (16, '14:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (17, '15:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (18, '15:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (19, '16:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (20, '16:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (21, '17:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (22, '17:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (23, '18:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (24, '18:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (25, '19:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (26, '19:30:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (27, '20:00:00');
INSERT INTO `clinica_cristiano`.`tb_horarioFuncionamento` (`id`, `horario`) VALUES (28, '20:30:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_ClinicaParceira`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_ClinicaParceira` (`id`, `observacao`, `dataInicioParceria`, `ativo`, `tb_PessoaJuridica_id`) VALUES (1, 'Criado para testes', '2018-01-01', 1, 3);
INSERT INTO `clinica_cristiano`.`tb_ClinicaParceira` (`id`, `observacao`, `dataInicioParceria`, `ativo`, `tb_PessoaJuridica_id`) VALUES (2, 'Criado para testes', '2018-01-02', 1, 4);
INSERT INTO `clinica_cristiano`.`tb_ClinicaParceira` (`id`, `observacao`, `dataInicioParceria`, `ativo`, `tb_PessoaJuridica_id`) VALUES (3, 'Criado para testes', '2018-01-03', 1, 5);
INSERT INTO `clinica_cristiano`.`tb_ClinicaParceira` (`id`, `observacao`, `dataInicioParceria`, `ativo`, `tb_PessoaJuridica_id`) VALUES (4, 'Criado para testes', '2018-01-04', 1, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Convenio`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (1, 1, 7);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (2, 1, 8);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (3, 1, 9);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (4, 1, 10);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (5, 1, 11);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (6, 1, 12);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (7, 1, 13);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (8, 1, 14);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (9, 1, 15);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (10, 1, 16);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (11, 1, 17);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (12, 1, 18);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (13, 1, 19);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (14, 1, 20);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (15, 1, 21);
INSERT INTO `clinica_cristiano`.`tb_Convenio` (`id`, `ativo`, `tb_PessoaJuridica_id`) VALUES (16, 1, 22);

COMMIT;


-- -----------------------------------------------------
-- Data for table `clinica_cristiano`.`tb_Funcionario_X_tb_UnidadeDaEmpresa`
-- -----------------------------------------------------
START TRANSACTION;
USE `clinica_cristiano`;
INSERT INTO `clinica_cristiano`.`tb_Funcionario_X_tb_UnidadeDaEmpresa` (`tb_Funcionario_id`, `tb_UnidadeDaEmpresa_id`) VALUES (1, 1);

COMMIT;

