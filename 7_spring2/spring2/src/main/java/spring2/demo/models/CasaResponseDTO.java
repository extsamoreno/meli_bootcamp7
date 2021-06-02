package spring2.demo.models;
//Se necesita desarrollar un API que reciba una Casa con su “nombre”, “dirección” y sus “habitaciones”, estas contienen un “nombre”, “ancho” y “largo”.
//Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
//Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
//Retornar el objeto con la habitación más grande.
//Retornar la cantidad de metros cuadrados por habitación.

import java.util.List;

public class CasaResponseDTO {
    private int m2Total;
    private int valorUsd;
    private Habitacion habitacionMasGrande;
    private List<M2PorHabitacion> m2PorHabitacion;

    public CasaResponseDTO(int m2Total, int valorUsd, Habitacion habitacionMasGrande, List<M2PorHabitacion> m2PorHabitacion) {
        this.m2Total = m2Total;
        this.valorUsd = valorUsd;
        this.habitacionMasGrande = habitacionMasGrande;
        this.m2PorHabitacion = m2PorHabitacion;
    }

    public int getM2Total() {
        return m2Total;
    }

    public void setM2Total(int m2Total) {
        this.m2Total = m2Total;
    }

    public int getValorUsd() {
        return valorUsd;
    }

    public void setValorUsd(int valorUsd) {
        this.valorUsd = valorUsd;
    }

    public Habitacion getHabitacionMasGrande() {
        return habitacionMasGrande;
    }

    public void setHabitacionMasGrande(Habitacion habitacionMasGrande) {
        this.habitacionMasGrande = habitacionMasGrande;
    }

    public List<M2PorHabitacion> getM2PorHabitacion() {
        return m2PorHabitacion;
    }

    public void setM2PorHabitacion(List<M2PorHabitacion> m2PorHabitacion) {
        this.m2PorHabitacion = m2PorHabitacion;
    }
}
