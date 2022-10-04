package com.asistencia.empleados.repository;

import com.asistencia.empleados.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "{call Employees_procedure()}", nativeQuery = true)
    List<Employee> listEmployeesProcedure();

    @Modifying
    @Transactional
    @Query(value = "{call save_employee_procedure(:nameIn, :lastNameIn, :ageIn, :credentialIn)}", nativeQuery = true)
    void saveProcedure(
            @Param("nameIn")String nameIn,
            @Param("lastNameIn")String lastNameIn,
            @Param("ageIn")int ageIn,
            @Param("credentialIn")String credentialIn
    );

}
