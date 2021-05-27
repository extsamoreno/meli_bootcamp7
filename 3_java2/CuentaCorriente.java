public class CuentaCorriente
{
    private double saldo;

    public static void main (String[] args)
    {
    }

    //region Constructor
    public CuentaCorriente()
    {
        this.saldo = 0;
    }

    public CuentaCorriente(Double saldo)
    {
        this.saldo = saldo;
    }

    public CuentaCorriente( CuentaCorriente cc)
    {
         this.saldo = cc.getSaldo();
    }

    // endregion

    // region Methods
    public void ingreso (double saldo)
    {
        this.saldo = this.saldo + saldo;
    }

    public void egreso (double saldo)
    {
        this.saldo = this.saldo - saldo;
    }

    public void reintegro (double saldo)
    {
        this.ingreso(saldo);
    }

    public void transferencia (CuentaCorriente cc, double saldo)
    {
        this.egreso(saldo);
        cc.ingreso(saldo);
    }
    //endregion

    //region Getters and Setters
    public double getSaldo( )
    {
        return this.saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
    //endregion

}
