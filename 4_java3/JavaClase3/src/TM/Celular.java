package TM;

public class Celular implements Precedeable<Celular>{

    private int number;
    private String titular;


    public Celular(String titular, int number)
    {
       this.setNumber(number);
       this.setTitular(titular);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        if (this.getNumber() < celular.getNumber())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public String toString() {
        String repr = "Celular número: " + this.getNumber() + ", Titular: " + this.getTitular();
        return repr;
    }
}
