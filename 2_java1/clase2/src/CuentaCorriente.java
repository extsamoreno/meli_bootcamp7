
public class CuentaCorriente {

    private double balance = 0;
    private String  accountNumber= "";

    public CuentaCorriente(){

    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente){

        this.balance = cuentaCorriente.getBalance();
        this.accountNumber = cuentaCorriente.getAccountNumber();
    }

    public CuentaCorriente(double balance, String accouString){

        this.accountNumber = accouString;
        this.balance = balance;
    }
    


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String getAccountNumber() {
        return this.accountNumber;
    }


    public void setBalance(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
