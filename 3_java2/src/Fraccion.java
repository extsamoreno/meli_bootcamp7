public class Fraccion {
    private int num,den;

    public Fraccion(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public Fraccion sumar(Fraccion fr2){
        int newDen = this.den*fr2.getDen();
        int newNum = this.num*fr2.getDen() + this.den*fr2.getNum();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion restar(Fraccion fr2){
        int newDen = this.den*fr2.getDen();
        int newNum = this.num*fr2.getDen() - this.den*fr2.getNum();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion multiplicar(Fraccion fr2){
        int newNum = this.num*fr2.getNum();
        int newDen = this.den*fr2.getDen();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion dividir(Fraccion fr2){
        int newNum = this.num*fr2.getDen();
        int newDen = this.den*fr2.getNum();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion sumar(int n){
        Fraccion fr2 = new Fraccion(n,1);
        int newDen = this.den*fr2.getDen();
        int newNum = this.num*fr2.getDen() + this.den*fr2.getNum();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion restar(int n){
        Fraccion fr2 = new Fraccion(n,1);
        int newDen = this.den*fr2.getDen();
        int newNum = this.num*fr2.getDen() - this.den*fr2.getNum();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion multiplicar(int n){
        Fraccion fr2 = new Fraccion(n,1);
        int newNum = this.num*fr2.getNum();
        int newDen = this.den*fr2.getDen();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public Fraccion dividir(int n){
        Fraccion fr2 = new Fraccion(n,1);
        int newNum = this.num*fr2.getDen();
        int newDen = this.den*fr2.getNum();
        Fraccion newFrac = new Fraccion(newNum, newDen);
        return newFrac;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }
}
