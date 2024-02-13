public class Principal {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        // Iniciar estaciones de trabajo con diferentes componentes y tiempos de producción
        EstacionDeTrabajo estacion1 = new EstacionDeTrabajo(fabrica, "Clavo", 1000);
        EstacionDeTrabajo estacion2 = new EstacionDeTrabajo(fabrica, "Contenedor", 1500);

        estacion1.start();
        estacion2.start();

        // Aquí podrías iniciar un hilo que supervise el ensamblaje o manejarlo dentro de Fabrica
    }
}
