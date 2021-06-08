package tm;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        // Cuenta Corriente:
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(42000);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(cuentaCorriente1);
        System.out.println("Saldo de la cuenta Corriente 2: " + cuentaCorriente2.getSaldo());

        // Contador:
        Contador contador1 = new Contador(15);
        contador1.incrementCounter();
        Contador contador2 = new Contador(contador1);
        System.out.println("Contador 2: " + contador2.getCounter());

        // Libro:
        Libro libro = new Libro("Harry Potter", "9780545582889", "Rowling, J. K.", false);
        libro.prestamo();
        System.out.println("Libro: " + libro);

        // Fracción:
        Fraccion f1 = new Fraccion(2, 3);
        Fraccion f2 = new Fraccion(4, 5);
        Fraccion f3 = new Fraccion(3, 8);
        Fraccion f4 = new Fraccion(4, 3);

        // Fracción - Suma:
        System.out.println("El resultado de la suma de fracciones es: " + f1.sumar(f2));
        System.out.println("El resultado de la suma de fracciones es: " + f3.sumar(f4));
        System.out.println("El resultado de la suma de fracciones (fracción + entero) es: " + f3.sumar(16));

        // Fracción - Resta:
        System.out.println("El resultado de la resta de fracciones es: " + f1.restar(f2));
        System.out.println("El resultado de la resta de fracciones es: " + f3.restar(f4));
        System.out.println("El resultado de la resta de fracciones (fracción - entero) es: " + f3.restar(16));

        // Fracción - Multiplicación:
        System.out.println("El resultado de la multiplicación de fracciones es: " + f1.multiplicar(f2));
        System.out.println("El resultado de la multiplicación de fracciones es: " + f3.multiplicar(f4));
        System.out.println("El resultado de la multiplicación de fracciones (fracción * entero) es: " + f3.multiplicar(16));

        // Fracción - División:
        System.out.println("El resultado de la división de fracciones es: " + f1.dividir(f2));
        System.out.println("El resultado de la división de fracciones es: " + f3.dividir(f4));
        System.out.println("El resultado de la división de fracciones (fracción / entero) es: " + f3.dividir(16));

        // Fecha:
        Fecha fecha = new Fecha(2021, Calendar.JUNE,4);
        fecha.addOneDay();
        System.out.println("La fecha es: " + fecha);
    }
}
