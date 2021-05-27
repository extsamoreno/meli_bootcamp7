package com.ejercitacion.mañana;

public class Main {

    public static void main(String[] args) {
	    Libro libro = new Libro();
	    libro.setAutor("jk");
	    libro.setIsbn("1929392");
	    libro.setTitulo("Harry Potter");

	    System.out.println(libro.toString());
    }
}
