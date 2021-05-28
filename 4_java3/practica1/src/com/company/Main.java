package com.company;

public class Main {

	public static void main(String[] args) {
		Persona[] p = {new Persona("asdf", 2), new Persona("qwer", 1)};

		for (var person: p)
			System.out.println(person.getName());

		SortUtil.ordenar(p);

		for (var person: p)
			System.out.println(person.getName());

		System.out.println();

		Celular[] c = {new Celular(2, "asdf"), new Celular(1, "qwer")};

		for (var celular: c)
			System.out.println(celular.getTitular());

		SortUtil.ordenar(c);

		for (var celular: c)
			System.out.println(celular.getTitular());
	}
}
