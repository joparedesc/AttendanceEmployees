package com.asistencia.empleados.service.implementation;

import com.asistencia.empleados.model.entity.Employee;
import com.asistencia.empleados.model.response.AttendanceEmployeeResponse;
import com.asistencia.empleados.repository.EmployeeRepository;
import com.asistencia.empleados.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<AttendanceEmployeeResponse> getAttendanceEmployees() {
        List<AttendanceEmployeeResponse> attendanceEmployeeResponseList= new ArrayList<>();
        List<Employee> employeeList=employeeRepository.listEmployeesProcedure();
        for (Employee employee:employeeList){
            AttendanceEmployeeResponse attendanceEmployeeResponse=new AttendanceEmployeeResponse();
            attendanceEmployeeResponse.setId(employee.getId());
            attendanceEmployeeResponse.setAge(employee.getAge());
            attendanceEmployeeResponse.setCredential(employee.getCredential());
            attendanceEmployeeResponse.setLastName(employee.getLastName());
            attendanceEmployeeResponse.setName(employee.getName());
            attendanceEmployeeResponseList.add(attendanceEmployeeResponse);
        }
        return attendanceEmployeeResponseList;
    }

    public void saveProcedure(Employee employee) {
        try {
            employeeRepository.saveProcedure(employee.getName(), employee.getLastName(), employee.getAge(),employee.getCredential());
        }catch (Exception exception){
            log.error("Exception in repository: ",exception.getMessage());
            throw new RuntimeException("Exception in repository: "+ exception);
        }

    }


}
