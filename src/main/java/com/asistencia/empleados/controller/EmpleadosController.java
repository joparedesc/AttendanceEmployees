package com.asistencia.empleados.controller;

import com.asistencia.empleados.constants.LogConstants;
import com.asistencia.empleados.model.entity.Employee;
import com.asistencia.empleados.model.response.AttendanceEmployeeResponse;
import com.asistencia.empleados.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EmpleadosController controller class.
 * @author jesu_
 */
@Slf4j
@RestController
@RequestMapping("${controller.base-path}")
public class EmpleadosController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(
        path = "${controller.api-attendance-employees}",
        produces = "application/json"
    )
    public ResponseEntity<List<AttendanceEmployeeResponse>> getAttendanceEmployees() {
        log.debug(LogConstants.START_APPLICATION_GET_ATTENDANCE_EMPLOYEES);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List<AttendanceEmployeeResponse> attendanceEmployeeResponseList=employeeService.getAttendanceEmployees();
        log.debug(LogConstants.FINISH_APPLICATION_GET_ATTENDANCE_EMPLOYEES);
        return new ResponseEntity<>(attendanceEmployeeResponseList, HttpStatus.OK);
    }

    @PostMapping
        (
                path = "${controller.api-attendance-employee}"
        )
    public ResponseEntity<?> save(@RequestBody Employee employee){
        employeeService.saveProcedure(employee);
        return new ResponseEntity("employee save", HttpStatus.CREATED);

    }

}
