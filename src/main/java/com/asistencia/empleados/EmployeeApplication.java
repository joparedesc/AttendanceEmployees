package com.asistencia.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * EmployeeApplication controller class.
 * @author jesu_
 */
@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.asistencia.empleados")
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
