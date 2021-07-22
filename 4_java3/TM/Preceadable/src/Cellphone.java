public class Cellphone implements Precedeable<Cellphone> {
    private String number;
    private String holder;

    @Override
    public int precedes(Cellphone cellphone) {
        return this.number.compareTo(cellphone.getNumber());
    }

    @Override
    public String toString() {
        return this.number + ", " + this.holder;
    }

    // constructor
    public Cellphone(String number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    // getters
    public String getNumber() {
        return this.number;
    }

    public String getHolder() {
        return this.holder;
    }

    // setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
