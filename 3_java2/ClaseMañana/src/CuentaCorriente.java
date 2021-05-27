public class CuentaCorriente {
    //gomez_florencia
    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta) {
        this.saldo = cuenta.getSaldo();
    }

    public void ingreso(double saldo) {
        this.setSaldo(this.getSaldo() + saldo);
    }

    public boolean egreso(double saldo) {
        if (this.getSaldo() > saldo) {
            this.setSaldo(this.getSaldo() - saldo);
            return true;
        }

        return false;
    }

    public void reintegro(double saldo) {
        this.ingreso(saldo);
    }

    public boolean transferencia(double saldo, CuentaCorriente cuenta) {
        if(this.getSaldo() < saldo) return false;

        this.egreso(saldo);
        cuenta.ingreso(saldo);

        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "saldo=" + saldo +
                '}';
    }
}