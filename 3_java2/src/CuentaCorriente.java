public class CuentaCorriente {
    private float saldo;
    private int nCuenta;

    public CuentaCorriente(int pnCuenta, float psaldo) {
        saldo = psaldo;
        nCuenta = pnCuenta;
    }

    public CuentaCorriente() {
    }

    public CuentaCorriente(CuentaCorriente cuenta) {
        saldo = cuenta.getSaldo();
        nCuenta = cuenta.getnCuenta();
    }
    public float getSaldo() {
        return saldo;
    }

    public int getnCuenta() {
        return nCuenta;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setnCuenta(int nCuenta) {
        this.nCuenta = nCuenta;
    }



    public void ingreso(float valor){
        saldo = saldo+valor;
    }
    public boolean egreso(float valor){
        valor = saldo-valor;
        if(valor>=0){
            saldo = valor;
            return true;
        }
        else {
            return false;
        }
    }
    public void reintegro(float valor){
        saldo = saldo+valor;
    }

    public boolean transferencia(CuentaCorriente cuenta1, CuentaCorriente cuenta2, float valor){
        if(cuenta1.egreso(valor)){
            cuenta2.ingreso(valor);
            return true;
        }
        else
        {
            return false;
        }

    }


}
