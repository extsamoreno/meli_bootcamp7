public class Fraccion {
    private float num;
    private float den;

    public Fraccion(float num, float den) {
        this.num = num;
        this.den = den;
    }

    public float suma(Fraccion frac1, Fraccion frac2){
        return ((frac1.num*frac2.den)+(frac1.den*frac2.num))/(frac1.den * frac2.den);
    }
    public float suma(Fraccion frac, float num){
        Fraccion frac2 = new Fraccion(num,1);
        return suma(frac,frac2);
    }

    public float resta(Fraccion frac1, Fraccion frac2){
        return ((frac1.num*frac2.den)-(frac1.den*frac2.num))/(frac1.den * frac2.den);
    }
    public float resta(Fraccion frac, float num){
        Fraccion frac2 = new Fraccion(num,1);
        return resta(frac,frac2);
    }

    public float mult(Fraccion frac1, Fraccion frac2){
        return (frac1.num * frac2.num)/(frac1.den * frac2.den);
    }
    public float mult(Fraccion frac, float num){
        return (frac.num*num/frac.den);
    }

    public float div(Fraccion frac1, Fraccion frac2){
        return (frac1.num*frac2.den)/(frac1.den*frac2.num);
    }
    public float div(Fraccion frac1, float num){
        Fraccion frac2 = new Fraccion(num,1);
        return div(frac1,frac2);
    }
}
