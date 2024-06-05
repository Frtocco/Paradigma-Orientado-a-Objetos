package ar.edu.uade.residuos.main;

import ar.edu.uade.residuos.modelo.Camion;
import ar.edu.uade.residuos.modelo.Contenedor;
import ar.edu.uade.residuos.modelo.Estacion;
import ar.edu.uade.residuos.modelo.GestorDeResiduos;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia del GestorDeResiduos
        GestorDeResiduos gestor = GestorDeResiduos.getInstancia();

        // Agregar algunas estaciones
        Estacion estacion1 = gestor.agregarEstacion(100);
        Estacion estacion2 = gestor.agregarEstacion(150);

        // Agregar algunos camiones
        Camion camion1 = gestor.agregarCamionHumedo(10, 20);
        Camion camion2 = gestor.agregarCamionReciclable(30, 40);
        Camion camion3 = gestor.agregarCamionMultiuso(50, 60);

        // Agregar algunos contenedores
        Contenedor contenedor1 = gestor.agregarContenedorHumedo(20, 10, 20);
        Contenedor contenedor2 = gestor.agregarContenedorReciclable(10, 30, 40);
        Contenedor contenedor3 = gestor.agregarContenedorReciclable(10, 50, 60);

        // Cargar contenedor en camión
        gestor.cargarContenedorACamion(camion1.getId(), contenedor1.getId());
        gestor.cargarContenedorACamion(camion2.getId(), contenedor2.getId());
        gestor.cargarContenedorACamion(camion3.getId(), contenedor3.getId());

        // Descargar camión en estación
        gestor.descargarCamionEnEstacion(camion1.getId(), estacion1.getId());
        gestor.descargarCamionEnEstacion(camion2.getId(), estacion2.getId());
    }
}
