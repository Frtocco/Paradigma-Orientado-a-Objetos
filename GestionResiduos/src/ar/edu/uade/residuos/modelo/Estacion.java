package ar.edu.uade.residuos.modelo;

public class Estacion {
    private static int contador = 0;
    
    private int id;
    private int capacidadTotal;
    private int capacidadOcupada;
    
    public Estacion(int capacidadTotal) {
        contador++;
        this.id = contador;
        this.capacidadTotal = capacidadTotal;
        this.capacidadOcupada = 0;
    }

    public int getId() {
        return id;
    }

    public boolean sosEstacion(int estacionId) {
        return this.id == estacionId;
    }

    public void cargarContenido(Camion camion) {
        int contenidoCamion = camion.getCapacidadOcupada();
        if (puedoCargarCantidadResiduos(contenidoCamion)) {
            agregarContenido(contenidoCamion);
            camion.vaciar();
        } else {
            throw new IllegalArgumentException("La estacion no tiene capacidad suficiente para descargar el camion");
        }
    }

    private void agregarContenido(int contenidoCamion) {
        this.capacidadOcupada += contenidoCamion;
    }

    private boolean puedoCargarCantidadResiduos(int contenidoCamion) {
        return this.capacidadOcupada + contenidoCamion <= this.capacidadTotal;
    }
}
