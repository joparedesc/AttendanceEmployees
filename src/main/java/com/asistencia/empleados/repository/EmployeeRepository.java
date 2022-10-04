package com.asistencia.empleados.repository;

import com.asistencia.empleados.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "{call Employees_procedure()}", nativeQuery = true)
    List<Employee> getEmployeesProcedure();

    @Modifying
    @Transactional
    @Query(value = "{call save_employee_procedure(:nameIn, :lastNameIn, :ageIn, :credentialIn)}", nativeQuery = true)
    void saveEmployeeProcedure(
            @Param("nameIn")String nameIn,
            @Param("lastNameIn")String lastNameIn,
            @Param("ageIn")int ageIn,
            @Param("credentialIn")String credentialIn
    );

    void deleteById(int id);

    Optional<Employee> findById(Integer integer);

}
