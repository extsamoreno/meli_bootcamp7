package com.ejercitacion;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


		while (true) {
			System.out.println("Please enter which exercise you want to execute (6 for exiting)");
			Scanner scanner = new Scanner(System.in);
			int opcion = scanner.nextInt();
			if (opcion > 6 || opcion < 1) {
				System.out.println("Exercise numbers go from 1 to 6");
				opcion = scanner.nextInt();
			}
			switch (opcion) {
				case 1:
					List<Integer> resultExercise1 = Exercise1.getEvenNumbers();
					System.out.println(resultExercise1);
					break;
				case 2:
					List<Integer> resultExercise2 = Exercise2.getMultiples();
					System.out.println(resultExercise2);
					break;
				case 3:
					boolean resultExercise3 = Exercise3.isPrime();
					String prime = (resultExercise3) ? "Yes, it's a prime number" : "No, it's not a prime number";
					System.out.println(prime);
					break;
				case 4:
					List<Integer> resultExercise4 = Exercise4.getPrimeNumbers();
					System.out.println(resultExercise4);
					break;
				case 5:
					List<Integer> resultExercise5 = Exercise5.getOccurrences();
					System.out.println(resultExercise5);
					break;
				case 6:
					System.exit(0);
			}
		}
    }
}
