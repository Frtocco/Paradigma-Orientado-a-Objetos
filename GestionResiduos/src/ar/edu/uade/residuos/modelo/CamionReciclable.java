package ar.edu.uade.residuos.modelo;

public class CamionReciclable extends Camion {

    public CamionReciclable(int posicionX, int posicionY) {
        super(posicionX, posicionY);
    }

    @Override
    public void cargarContenedor(Contenedor contenedor) {
        validarPosicionDeContenedor(contenedor);
        contenedor.cargarEnCamionReciclable(this);
    }

    @Override
    public int getCapacidadMaxima() {
        return 30;
    }
    
}
