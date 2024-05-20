package ar.edu.uade.residuos.modelo;

public class CamionMultiresiduo extends Camion {

    public CamionMultiresiduo(int posicionX, int posicionY) {
        super(posicionX, posicionY);
    }

    @Override
    public void cargarContenedor(Contenedor contenedor) {
        validarPosicionDeContenedor(contenedor);
        contenedor.cargarEnCamionMultiresiduo(this);
    }

    @Override
    public int getCapacidadMaxima() {
        return 50;
    }
    
}
