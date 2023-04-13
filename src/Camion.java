public class Camion extends Vehiculo {
    public Camion(String patente) {
        super(patente);
    }

    @Override
    public int getEspacios() {
        return 2;
    }
}