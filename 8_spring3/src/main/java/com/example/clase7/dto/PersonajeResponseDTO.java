package com.example.clase7.dto;

public class PersonajeResponseDTO {
    private String nombre;
    private String altura;
    private String masa;
    private String colorPelo;
    private String colorPiel;
    private String colorOjo;
    private String anioNacimiento;
    private String genero;
    private String planeta;
    private String especie;

    public PersonajeResponseDTO() {
    }

    public PersonajeResponseDTO(String nombre, String altura, String masa, String colorPelo, String colorPiel, String colorOjo, String anioNacimiento, String genero, String planeta, String especie) {
        this.nombre = nombre;
        this.altura = altura;
        this.masa = masa;
        this.colorPelo = colorPelo;
        this.colorPiel = colorPiel;
        this.colorOjo = colorOjo;
        this.anioNacimiento = anioNacimiento;
        this.genero = genero;
        this.planeta = planeta;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    public String getColorOjo() {
        return colorOjo;
    }

    public void setColorOjo(String colorOjo) {
        this.colorOjo = colorOjo;
    }

    public String getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(String anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
