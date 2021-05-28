public class Main {
    public static void main(String[] args) {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        System.out.println(cuentaCorriente.getSaldo());
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(100.5,915234211);
        System.out.println(cuentaCorriente1.getSaldo());
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(cuentaCorriente1);
        cuentaCorriente2.setSaldo(25.3);
        System.out.println(cuentaCorriente2.getSaldo());

        Contador contador = new Contador();
        contador.incrementar(2);
        contador.decrementar(1);
        System.out.println(contador.getValor());
        Contador contador1 = new Contador(3);
        contador1.incrementar(2);
        contador1.decrementar(1);
        System.out.println(contador1.getValor());
        Contador contador2 = new Contador(contador1);
        contador2.incrementar(2);
        contador2.decrementar(1);
        System.out.println(contador2.getValor());

        Libro libro = new Libro();
        libro.setAutor("Rowling");
        libro.setIsbn("9780545582889");
        libro.setTitulo("Harry Potter");
        System.out.println(libro);
        Libro libro1 = new Libro("Satanas","9780545582889","Mario Mendoza");
        System.out.println(libro1);

        Fraccion fraccion = new Fraccion();
        System.out.println(fraccion.sumar(2.4,4.5));
        System.out.println(fraccion.sumar(2.4,5));
        System.out.println(fraccion.restar(2.4,1.2));
        System.out.println(fraccion.restar(2.4,2));
        System.out.println(fraccion.multiplicar(2.4,2.4));
        System.out.println(fraccion.multiplicar(2.4,2));
        System.out.println(fraccion.dividir(2.4,2.4));
        System.out.println(fraccion.dividir(2.4,1));

        Fecha fecha = new Fecha(16,10,2016);
        System.out.println(fecha);
        fecha.sumarDia(1);
        System.out.println(fecha);

        String rpad = StringUtil.rpad("hola osi",'!',10);
        System.out.println(rpad);
        System.out.println(StringUtil.ltrim("         palabra   !"));
        System.out.println(StringUtil.rtrim("!         palabra      "));
        System.out.println(StringUtil.trim("         palabra   !     "));
        System.out.println(StringUtil.indexOfN("letra palabra   !",'a',2));










    }
}
