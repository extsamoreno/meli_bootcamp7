package cumpleChiqui;

import java.util.ArrayList;

public class Evento {

 private String eventoNombre;
 private fuegoArtificialPack fuegos;
 private ArrayList<Invitado> invitados;


 public Evento(String eventoNombre, fuegoArtificialPack fuegos, ArrayList<Invitado> invitados) {
  this.eventoNombre = eventoNombre;
  this.fuegos = fuegos;
  this.invitados = invitados;
 }

 public void ejecutarEvento() {
  System.out.println("La chiqui apago las velas ");
  fuegos.getSonidoAlExplotar();
  System.out.println("Luego de terminar la torta se escucha.. ");
  for (Invitado i : invitados) {
   i.gritoPosComida();
  }
 }


 }



