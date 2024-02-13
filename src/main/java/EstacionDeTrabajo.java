public class EstacionDeTrabajo extends Thread {
    private Fabrica fabrica;
    private String nombreComponente;
    private int tiempoProduccion;

    public EstacionDeTrabajo(Fabrica fabrica, String nombreComponente, int tiempoProduccion) {
        this.fabrica = fabrica;
        this.nombreComponente = nombreComponente;
        this.tiempoProduccion = tiempoProduccion;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(tiempoProduccion); // Simula el tiempo de producción
                Componente componente = new Componente(nombreComponente);
                fabrica.producirComponente(componente);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        }
    }
}
