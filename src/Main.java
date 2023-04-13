import java.util.ArrayList;
import java.util.List;

class TestCochera {
    public static void main(String[] args) throws InterruptedException {
        Cochera cochera = new Cochera(10);

        List<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (Math.random() < 0.5) {
                vehiculos.add(new Auto("A" + i));
            } else {
                vehiculos.add(new Camion("C" + i));
            }
        }

        List<Thread> threads = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            Thread thread = new Thread(() -> {
                try {
                    cochera.ingresarVehiculo(vehiculo);
                    System.out.println(vehiculo + " ingresó a la cochera");
                    cochera.imprimirEstado();
                    Thread.sleep((long) (Math.random() * 5000));
                    cochera.sacarVehiculo(vehiculo);
                    System.out.println(vehiculo + " salió de la cochera");
                    cochera.imprimirEstado();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
