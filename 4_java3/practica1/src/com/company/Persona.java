package com.company;

public class Persona implements Precedable<Persona> {
    String m_name;
    int m_dni;

    public Persona(String name, int dni) {
        m_name = name;
        m_dni = dni;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public int getDni() {
        return m_dni;
    }

    public void setDni(int dni) {
        m_dni = dni;
    }

    @Override
    public int precedeA(Persona persona) {
        return m_dni - persona.getDni();
    }
}
