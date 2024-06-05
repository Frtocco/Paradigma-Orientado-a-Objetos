package ar.edu.uade.residuos.modelo;

public class ContenedorReciclable extends Contenedor {

    public ContenedorReciclable(int capacidadOcupada, int posicionX, int posicionY) {
        super(capacidadOcupada, posicionX, posicionY);
    }

    @Override
    protected int getCapacidadMaxima() {
        return 10;
    }

    @Override
    public void cargarEnCamionReciclable(CamionReciclable camionReciclable) {
        cargarEnCamion(camionReciclable);
    }
    
}
