package ej1;

// Esta interfaz va a poder comprar distinto tipo de datos
public interface Precedable <T> {
  public int precedeA(T t); // le pasamos el tipo de dato
}
