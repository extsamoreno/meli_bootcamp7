package com.meli.spring_day_2.PracticaTarde.Dto;

import com.meli.spring_day_2.PracticaTarde.Clases.Alumno;

public class DiplomaDto {
    private String msg;
    private float promedio;
    private Alumno alumno;

    public DiplomaDto() {
    }

    public DiplomaDto(String msg, float promedio, Alumno alumno) {
        this.msg = msg;
        this.promedio = promedio;
        this.alumno = alumno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
