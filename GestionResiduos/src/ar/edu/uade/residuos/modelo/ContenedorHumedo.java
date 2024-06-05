package ar.edu.uade.residuos.modelo;

public class ContenedorHumedo extends Contenedor {

    public ContenedorHumedo(int capacidadOcupada, int posicionX, int posicionY) {
        super(capacidadOcupada, posicionX, posicionY);
    }

    @Override
    protected int getCapacidadMaxima() {
        return 20;
    }

    @Override
    public void cargarEnCamionHumedo(CamionHumedo camionHumedo) {
        cargarEnCamion(camionHumedo);
    }
    
}
