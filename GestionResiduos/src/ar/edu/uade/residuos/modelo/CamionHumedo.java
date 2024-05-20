package ar.edu.uade.residuos.modelo;

public class CamionHumedo extends Camion {

    public CamionHumedo(int posicionX, int posicionY) {
        super(posicionX, posicionY);
    }

    @Override
    public void cargarContenedor(Contenedor contenedor) {
        validarPosicionDeContenedor(contenedor);
        contenedor.cargarEnCamionHumedo(this);
    }

    @Override
    public int getCapacidadMaxima() {
        return 40;
    }
    
}
