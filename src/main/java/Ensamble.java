import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ensamble {
    private Lock lock = new ReentrantLock();

    public void ensamblarProducto(Componente componente1, Componente componente2) {
        lock.lock();
        try {
            // Lógica de ensamblaje aquí
            System.out.println("Ensamblado producto con " + componente1.getNombre() + " y " + componente2.getNombre());
        } finally {
            lock.unlock();
        }
    }
}
