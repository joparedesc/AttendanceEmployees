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
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<AttendanceEmployeeResponse> getAttendanceEmployees() {
        List<AttendanceEmployeeResponse> attendanceEmployeeResponseList= new ArrayList<>();
        List<Employee> employeeList=employeeRepository.getEmployeesProcedure();
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
            employeeRepository.saveEmployeeProcedure(employee.getName(), employee.getLastName(), employee.getAge(),employee.getCredential());
        }catch (Exception exception){
            log.error("Exception in repository: ",exception.getMessage());
            throw new RuntimeException("Exception in repository: "+ exception);
        }

    }

    public AttendanceEmployeeResponse getEmployeeById(int id) {
        Optional<Employee> optionalEmployee;
        AttendanceEmployeeResponse attendanceEmployeeResponse=new AttendanceEmployeeResponse();
        try{
            optionalEmployee=employeeRepository.findById(id);

            if(optionalEmployee.isPresent()){
                attendanceEmployeeResponse.setName(optionalEmployee.get().getName());
                attendanceEmployeeResponse.setLastName(optionalEmployee.get().getLastName());
                attendanceEmployeeResponse.setCredential(optionalEmployee.get().getCredential());
                attendanceEmployeeResponse.setAge(optionalEmployee.get().getAge());
                attendanceEmployeeResponse.setId(optionalEmployee.get().getId());
            }else{
            throw new RuntimeException(
                    String.format("Employee not found with id value: [%d]", id)
            );
        }

        }catch (Exception exception){
            log.error("Exception in repository: ",exception.getMessage());
            throw new RuntimeException("Exception  (getEmployeeById) in service: "+ exception);
        }
        return attendanceEmployeeResponse;

    }

    public boolean deleteEmployee(int id) {
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            log.error("Exception  (deleteById) in service: ",e.getMessage());
            return false;
        }
    }

    public Employee updateEmployee(int id,Employee employee){
        Optional<Employee> optionalEmployee;

        optionalEmployee=employeeRepository.findById(id);

        Employee employeeUpdate=new Employee();
        try{
            if(optionalEmployee.isPresent()){
                employeeUpdate=optionalEmployee.get();

                employeeUpdate.setName(employee.getName());
                employeeUpdate.setLastName(employee.getLastName());
                employeeUpdate.setCredential(employee.getCredential());
                employeeUpdate.setAge(employee.getAge());
                employeeUpdate=employeeRepository.save(employeeUpdate);
            }else{
                throw new RuntimeException(
                        String.format("Employee not found with id value: [%d]", id)
                );
            }
            return employeeUpdate;
        }catch (Exception e){
            log.error("Exception  (updateEmployee) in service: ",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
