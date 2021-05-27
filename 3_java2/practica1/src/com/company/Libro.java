package com.company;

public class Libro {
	String m_titulo;
	String m_isbn;
	String m_autor;

	String m_estado;

	public Libro(String titulo, String isbn, String autor) {
		m_titulo = titulo;
		m_isbn = isbn;
		m_autor = autor;
	}

	public Libro(Libro other) {
		m_titulo = other.getTitulo();
		m_isbn = other.getIsbn();
		m_autor = other.getAutor();
	}

	public String getTitulo() {
		return m_titulo;
	}

	public void setTitulo(String titulo) {
		m_titulo = titulo;
	}

	public String getIsbn() {
		return m_isbn;
	}

	public void setIsbn(String isbn) {
		m_isbn = isbn;
	}

	public String getAutor() {
		return m_autor;
	}

	public void setAutor(String autor) {
		m_autor = autor;
	}

	public void prestamo() {
		m_estado = "prestado";
	}

	public void devolucion() {
		m_estado = "disponible";
	}

	@Override
	public String toString() {
		return String.join(m_titulo, "; ", m_isbn, "; ", m_autor);
	}
}
