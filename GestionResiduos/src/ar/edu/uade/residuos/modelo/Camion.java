package ar.edu.uade.residuos.modelo;

public abstract class Camion {
    private static int contador = 0;

    private int id;
    private int capacidadOcupada;
    private int posicionX;
    private int posicionY;
    
    protected Camion(int posicionX, int posicionY) {
        contador++;
        this.id = contador;
        this.capacidadOcupada = 0;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getId() {
        return id;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public boolean sosCamion(int camionId) {
        return this.id == camionId;
    }

    public void descargarContenedor(Contenedor contenedor) {
        int cantidadResiduos = contenedor.getCapacidadOcupada();
        
        if (puedoCargarCantidadResiduos(cantidadResiduos)) {
            cargarResiduos(cantidadResiduos);
            contenedor.vaciar();
        } else {
            throw new IllegalArgumentException("El camion no tiene capacidad disponible para cargar el contenedor");
        }
    }

    public void vaciar() {
        this.capacidadOcupada = 0;
    }

    protected void validarPosicionDeContenedor(Contenedor contenedor) {
        if (!contenedor.estasEnPosicion(getPosicionX(), getPosicionY())) {
            throw new IllegalArgumentException("Camnion y Contenedor estan en diferente posicion");
        }
    }

    private void cargarResiduos(int cantidadResiduos) {
        this.capacidadOcupada += cantidadResiduos;
    }

    private boolean puedoCargarCantidadResiduos(int cantidadResiduos) {
        return getCapacidadOcupada() + cantidadResiduos <= getCapacidadMaxima();
    }

    public abstract void cargarContenedor(Contenedor contenedor);

    public abstract int getCapacidadMaxima();
}
