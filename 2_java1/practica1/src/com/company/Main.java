package com.company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ejercicio1();
		ejercicio2();
		ejercicio3();
		ejercicio4();
		ejercicio5();
	}


	// Ejercicio 1 -----------------------------------------------------------
	public static void ejercicio1() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ejercicio 1: ");
		pares(scanner.nextInt());
	}

	public static void pares(int n) {
		for (int i = 0, j = 1 ; i < n; ++j)
			if (j%2 == 0) {
				System.out.println(j);
				++i;
			}
	}


	// Ejercicio 2 -----------------------------------------------------------
	public static void ejercicio2() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ejercicio 2: ");
		multiplos(scanner.nextInt(), scanner.nextInt());
	}

	public static void multiplos(int n, int m) {
		for (int i = 1; i <= n; ++i)
			System.out.println(i*m);
	}


	// Ejercicio 3 -----------------------------------------------------------
	public static void ejercicio3() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ejercicio 3: ");
		if (primo(scanner.nextInt()))
			System.out.println("Es primo.");
		else
			System.out.println("No es primo.");
	}

	public static boolean primo(int n) {
		for (int i = 2; i <= Math.sqrt(n); ++i)
			if (n%i == 0)
				return false;

		return true;
	}


	// Ejercicio 4 -----------------------------------------------------------
	public static void ejercicio4() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ejercicio 4: ");
		primos(scanner.nextInt());
	}

	public static void primos(int n) {
		for (int i = 0, j = 1; i < n; ++j)
			if (primo(j)) {
				System.out.println(j);
				++i;
			}
	}


	// Ejercicio 5 -----------------------------------------------------------
	public static void ejercicio5() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ejercicio 5: ");
		digitos(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
	}

	public static void digitos(int n, int m, int d) {
		for (int i = 0, j = 0; i < n; ++j)
			for (int aux = j, c = 0; aux != 0; aux /= 10) {
				if (aux%10 == d)
					++c;

				if (c >= m) {
					System.out.println(j);
					++i;
					break;
				}
			}
	}
}
