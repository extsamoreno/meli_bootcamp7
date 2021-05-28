public class CuentaCorriente {

    private double balance;
    private String  accountNumber;

    public CuentaCorriente(){

        this.balance = 0;
        this.accountNumber = "";

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


    public void deposit(double amount){

        this.balance += amount;

    }
    public boolean withdrawal(double amount){

        if(amount <= this.balance ){
            this.balance -= amount;
            return true;
        }

        return false;
        

    }

    public void transfer(double amount, CuentaCorriente cuenta){

        if(this.withdrawal(amount)){
            cuenta.deposit(amount);
        }

    }



}
