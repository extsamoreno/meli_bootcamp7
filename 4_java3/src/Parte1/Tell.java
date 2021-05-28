package Parte1;

public class Tell implements IPrecedable<Tell>{

    private String Titular = " ";
    private int num;

    public Tell() {
    }

    public Tell(String titular, int num) {
        Titular = titular;
        this.num = num;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int precedeA(Tell tell) {
        return this.num - tell.num;
    }

    @Override
    public int precedeString(Tell tell) {
        return this.getTitular().compareToIgnoreCase(tell.getTitular());
    }

    @Override
    public String toString() {
        return "Tell{" +
                "Titular='" + Titular + '\'' +
                ", num=" + num +
                '}';
    }
}
