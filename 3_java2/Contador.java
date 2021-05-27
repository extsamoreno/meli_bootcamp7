import java.util.Arrays;

public class Contador
{
    private int valor;

    public static void main (String[] args)
    {
        Contador contador2 = new Contador();
        contador2.valor = 3;

        Contador c1 = new Contador(2);
        Contador c2 = new Contador();
        Contador c3 = new Contador(contador2.getValor());

        int increment = c2.increment(c1);
        int increment2 = c2.increment(c3);

        int decrese = c1.decrease(c2);
        int decrese2 = c3.decrease(c1);

        System.out.println(c2.valor + " + " + c1.valor + " = " + increment);
        System.out.println(c2.valor + " + " + c3.valor + " = " + increment2);

        System.out.println(c1.valor + " - " + c2.valor + " = " + decrese);
        System.out.println(c3.valor + " - " + c1.valor + " = " + decrese2);

    }

    //region Constructor
    public Contador()
    {
        this.valor = 0;
    }

    public Contador(int a)
    {
        this.valor =  a;
    }

    // constructor copia
    public Contador(Contador c)
    {
        this.valor = c.valor;
    }

    //endregion

    //region methods
    public int increment(Contador c)
    {
        return this.valor + c.valor;
    }

    public int decrease(Contador c)
    {
        return this.valor - c.valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    //endregion
}
