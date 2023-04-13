public abstract class Vehiculo {
    private String patente;

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public abstract int getEspacios();

    @Override
    public String toString() {
        return "Vehículo " + getClass().getSimpleName() + " con patente " + patente;
    }
}
