package com.asistencia.empleados;

import com.asistencia.empleados.model.entity.Employee;
import com.asistencia.empleados.service.EmployeeService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeApplicationTests {
	@Autowired
	EmployeeService employeeService;
	@Test
	void contextLoads() {
	}
	@Test
	void getAttendanceEmployees() {
	}

	@Test
	void saveProcedure() {
		Employee employee=new Employee();
		employee.setName("rodolfo");
		employee.setLastName("jaimes");
		employee.setAge(56);
		employee.setCredential("rj56");

		employeeService.saveProcedure(employee);
		Gson gson = new Gson();
		String jsonShoppingCartMap =gson.toJson(employeeService.getAttendanceEmployees());
		System.out.println("List of employees : "+jsonShoppingCartMap);
	}

}
