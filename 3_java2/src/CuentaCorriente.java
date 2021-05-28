public class CuentaCorriente {

    private long id;
    private double balance;

    public CuentaCorriente() {}

    public CuentaCorriente(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.id = cuentaCorriente.getId();
        this.balance = cuentaCorriente.getBalance();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void ingreso(double amount){

    }
    public static void egreso(double amount){

    }
    public static void reintegro(double amount){

    }
    public static void tranferencia(CuentaCorriente account, double amount){

    }
}
