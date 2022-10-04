package com.asistencia.empleados.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceEmployeeResponse {

    private int id;

    private String name;
    private String lastName;
    private int age;

    private String credential;
}
