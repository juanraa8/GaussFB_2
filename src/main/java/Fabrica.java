import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fabrica implements Observador {
    private Queue<Componente> componentes = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Ensamble ensamblaje = new Ensamble();

    public void producirComponente(Componente componente) {
        lock.lock();
        try {
            componentes.add(componente);
            System.out.println("Componente producido: " + componente.getNombre());
            notEmpty.signal(); // Notificar a la línea de ensamblaje que hay componentes
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void actualizar(Componente componente) {
        lock.lock();
        try {
            while (componentes.size() < 2) {
                notEmpty.await(); // Esperar hasta que haya suficientes componentes para ensamblar
            }
            Componente componente1 = componentes.poll();
            Componente componente2 = componentes.poll();
            ensamblaje.ensamblarProducto(componente1, componente2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        } finally {
            lock.unlock();
        }
    }
}
