public abstract class FiguraGeometrica {

    public abstract double area();

    @Override
    public String toString(){

        return Double.toString(this.area());    
    }
    
}
