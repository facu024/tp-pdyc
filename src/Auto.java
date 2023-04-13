public class Auto extends Vehiculo {
    public Auto(String patente) {
        super(patente);
    }

    @Override
    public int getEspacios() {
        return 1;
    }
}