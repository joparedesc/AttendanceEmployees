package com.asistencia.empleados.service;

import com.asistencia.empleados.model.entity.Employee;
import com.asistencia.empleados.model.response.AttendanceEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<AttendanceEmployeeResponse> getAttendanceEmployees();

    void saveProcedure(Employee employee);
}
