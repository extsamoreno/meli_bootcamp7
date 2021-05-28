package Ex1;

public class Celular implements Precedable<Celular> {

    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Celular() {
    }

    public Celular(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public int precedeA(Celular celular) {
        if (this.getNumber() > celular.getNumber())
            return 0;
        else
            return 1;
    }
}
