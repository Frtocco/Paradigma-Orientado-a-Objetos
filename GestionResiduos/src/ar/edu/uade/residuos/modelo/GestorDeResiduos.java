package ar.edu.uade.residuos.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorDeResiduos {
    private static GestorDeResiduos instancia;

    private List<Estacion> estaciones;
    private List<Camion> camiones;
    private List<Contenedor> contenedores;

    private GestorDeResiduos() {
        this.estaciones = new ArrayList<>();
        this.camiones = new ArrayList<>();
        this.contenedores = new ArrayList<>();
    }

    public static GestorDeResiduos getInstancia() {
        if (instancia == null) {
            instancia = new GestorDeResiduos();
        }
        return instancia;
    }

    public Camion agregarCamionHumedo(int posicionX, int posicionY) {
        Camion camion = new CamionHumedo(posicionX, posicionY);
        this.camiones.add(camion);
        return camion;
    }

    public Camion agregarCamionReciclable(int posicionX, int posicionY) {
        Camion camion = new CamionReciclable(posicionX, posicionY);
        this.camiones.add(camion);
        return camion;
    }

    public Camion agregarCamionMultiuso(int posicionX, int posicionY) {
        Camion camion = new CamionMultiresiduo(posicionX, posicionY);
        this.camiones.add(camion);
        return camion;
    }

    public Contenedor agregarContenedorHumedo(int cantidadOcupada, int posicionX, int posicionY) {
        Contenedor contenedor = new ContenedorHumedo(cantidadOcupada, posicionX, posicionY);
        this.contenedores.add(contenedor);
        return contenedor;
    }

    public Contenedor agregarContenedorReciclable(int cantidadOcupada, int posicionX, int posicionY) {
        Contenedor contenedor = new ContenedorReciclable(cantidadOcupada, posicionX, posicionY);
        this.contenedores.add(contenedor);
        return contenedor;
    }

    public Estacion agregarEstacion(int capacidadTotal) {
        Estacion estacion = new Estacion(capacidadTotal);
        this.estaciones.add(estacion);
        return estacion;
    }

    public void cargarContenedorACamion(int camionId, int contenedorId) {
        Camion camion = buscarCamion(camionId);
        Contenedor contenedor = buscarContenedor(contenedorId);
        
        camion.cargarContenedor(contenedor);
    }

    public void descargarCamionEnEstacion(int camionId, int estacionId) {
        Camion camion = buscarCamion(camionId);
        Estacion estacion = buscarEstacion(estacionId);

        estacion.cargarContenido(camion);
    }

    private Camion buscarCamion(int camionId) {
        for (Camion camion : camiones) {
            if (camion.sosCamion(camionId)) {
                return camion;
            }
        }
        throw new IllegalArgumentException("No se encontró un camión con el ID especificado: " + camionId);
    }

    private Contenedor buscarContenedor(int contenedorId) {
        for (Contenedor contenedor : contenedores) {
            if (contenedor.sosContenedor(contenedorId)) {
                return contenedor;
            }
        }
        throw new IllegalArgumentException("No se encontró un contenedor con el ID especificado: " + contenedorId);
    }

    private Estacion buscarEstacion(int estacionId) {
        for (Estacion estacion : estaciones) {
            if (estacion.sosEstacion(estacionId)) {
                return estacion;
            }
        }
        throw new IllegalArgumentException("No se encontró una estacion con el ID especificado: " + estacionId);
    }
    
}
