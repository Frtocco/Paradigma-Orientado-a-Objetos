package ar.edu.uade.residuos.modelo;

public abstract class Contenedor {
    private static int contador = 0;

    private int id;
    private int capacidadOcupada;
    private int posicionX;
    private int posicionY;

    protected Contenedor(int capacidadOcupada, int posicionX, int posicionY) {
        contador++;
        this.id = contador;
        this.capacidadOcupada = capacidadOcupada;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getId() {
        return id;
    }

    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public boolean sosContenedor(int contenedorId) {
        return this.id == contenedorId;
    }

    public boolean estasEnPosicion(int posicionX, int posicionY) {
        return this.posicionX == posicionX && this.posicionY == posicionY;
    }

    public void cargarEnCamionHumedo(CamionHumedo camionHumedo) {
        throw new UnsupportedOperationException("Este tipo de contenedor no se soporta en camiones humedos");
    }

    public void cargarEnCamionReciclable(CamionReciclable camionReciclable) {
        throw new UnsupportedOperationException("Este tipo de contenedor no se soporta en camiones de reciclables");
    }

    public void cargarEnCamionMultiresiduo(CamionMultiresiduo camionMultiresiduo) {
        cargarEnCamion(camionMultiresiduo);
    }

    public void vaciar() {
        this.capacidadOcupada = 0;
    }

    protected void cargarEnCamion(Camion camion) {
        if (!estasLleno()) {
            throw new IllegalArgumentException("El contenedor no esta lleno");
        }
        camion.descargarContenedor(this);
    }

    private boolean estasLleno() {
        return this.getCapacidadOcupada() == getCapacidadMaxima();
    }

    protected abstract int getCapacidadMaxima();
}
