import java.util.ArrayList;
import java.util.List;

public class Cochera {
    private int lugaresDisponibles;
    private List<Vehiculo> vehiculos;

    public Cochera(int n) {
        lugaresDisponibles = n;
        vehiculos = new ArrayList<>();
    }

    public synchronized void ingresarVehiculo(Vehiculo vehiculo) throws InterruptedException {
        while (vehiculo.getEspacios() > lugaresDisponibles) {
            wait();
        }

        vehiculos.add(vehiculo);
        lugaresDisponibles -= vehiculo.getEspacios();

        notifyAll();
    }

    public synchronized void sacarVehiculo(Vehiculo vehiculo) throws InterruptedException {
        while (!vehiculos.contains(vehiculo)) {
            wait();
        }

        vehiculos.remove(vehiculo);
        lugaresDisponibles += vehiculo.getEspacios();

        notifyAll();
    }

    public synchronized void imprimirEstado() {
        System.out.println("Lugares disponibles: " + lugaresDisponibles);

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }
}

