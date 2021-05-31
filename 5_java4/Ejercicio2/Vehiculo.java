public class Vehiculo {
    Integer velocidad, aceleracion, anguloDeGiro;
    String patente;
    Integer peso, ruedas;

    public Vehiculo(){}

    public Vehiculo(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente, Integer peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Velocidad: " + velocidad + ", " +
                "Aceleracion: " + aceleracion + ", " +
                "Angulo de Giro: " + anguloDeGiro + ", " +
                "Patente: " + patente + ", " +
                "Peso: " + peso + ", " +
                "Ruedas: " + ruedas;
    }

    //region Getters and Setters
    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Integer aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Integer getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Integer anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
    //endregion
}
