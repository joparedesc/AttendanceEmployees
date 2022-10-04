--Script to create data base
create database bd_asistencia_elecktra;
USE bd_asistencia_elecktra;

--Store procedure to consult employees
CREATE DEFINER=`root`@`localhost` PROCEDURE `Employees_procedure`()
BEGIN
	SELECT * FROM employee;
END
--Store procedure to save employees
CREATE DEFINER=`root`@`localhost` PROCEDURE `save_employee_procedure`( IN `nameIn` VARCHAR(255), IN `lastNameIn` VARCHAR(255), IN `ageIn` INT(11), IN `credentialIn` VARCHAR(255))
BEGIN
	insert into bd_asistencia_elecktra.employee (name,last_name,age, credential) VALUES(nameIn, lastNameIn, ageIn,credentialIn);
END