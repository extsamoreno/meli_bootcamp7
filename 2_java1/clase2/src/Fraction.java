public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(){

        this.numerator=1;
        this.denominator=1;
        
    }
    public Fraction(int numerator, int denominator){

        this.numerator= numerator;
        this.denominator= denominator;
        
    }
    
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }



    public static Fraction add(int a, int b){

        return new Fraction(a+b , 1);

    }
    public static Fraction add(Fraction a, Fraction b){

        return new Fraction(a.getNumerator()+b.getNumerator() , a.getDenominator()*b.getDenominator());

    }
    public static Fraction add(Fraction a, int b){

        Fraction fraction = new Fraction(b,1);
        return Fraction.add(a,fraction);

    }
    public static Fraction add(int a, Fraction b){

        Fraction fraction = new Fraction(a,1);
        return Fraction.add(fraction,b);

    }




    public static Fraction sub(int a, int b){

        return new Fraction(a-b , 1);

    }
    public static Fraction sub(Fraction a, Fraction b){

        return new Fraction(a.getNumerator()-b.getNumerator() , a.getDenominator()*b.getDenominator());

    }
    public static Fraction sub(Fraction a, int b){

        Fraction fraction = new Fraction(b,1);
        return Fraction.sub(a,fraction);

    }
    public static Fraction sub(int a, Fraction b){

        Fraction fraction = new Fraction(a,1);
        return Fraction.sub(fraction,b);

    }



    public static Fraction multiply(int a, int b){

        return new Fraction(a*b , 1);

    }
    public static Fraction multiply(Fraction a, Fraction b){

        return new Fraction(a.getNumerator()*b.getNumerator() , a.getDenominator()*b.getDenominator());

    }
    public static Fraction multiply(Fraction a, int b){

        Fraction fraction = new Fraction(b,1);
        return Fraction.multiply(a,fraction);

    }
    public static Fraction multiply(int a, Fraction b){

        Fraction fraction = new Fraction(a,1);
        return Fraction.multiply(fraction,b);

    }




    public static Fraction div(int a, int b){

        return new Fraction(a/b , 1);

    }
    public static Fraction div(Fraction a, Fraction b){

        return new Fraction(a.getNumerator()*b.getDenominator() , a.getDenominator()*b.getNumerator());

    }
    public static Fraction div(Fraction a, int b){

        Fraction fraction = new Fraction(b,1);
        return Fraction.div(a,fraction);

    }
    public static Fraction div(int a, Fraction b){

        Fraction fraction = new Fraction(a,1);
        return Fraction.div(fraction,b);

    }

}
