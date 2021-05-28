package com.company;

public class Celular implements Precedable<Celular> {
    int m_numero;
    String m_titular;

    public Celular(int numero, String titular) {
        m_numero = numero;
        m_titular = titular;
    }

    public int getNumero() {
        return m_numero;
    }

    public void setNumero(int numero) {
        m_numero = numero;
    }

    public String getTitular() {
        return m_titular;
    }

    public void setTitular(String titular) {
        m_titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        return m_numero - celular.getNumero();
    }
}
