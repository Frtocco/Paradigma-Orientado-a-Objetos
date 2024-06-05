package ar.edu.uade.main;

import ar.edu.uade.banco.Banco;
import ar.edu.uade.banco.cliente.Cliente;
import ar.edu.uade.banco.exceptions.ClienteInactivoException;
import ar.edu.uade.banco.exceptions.ClienteNoEncontradoException;
import ar.edu.uade.banco.exceptions.CuentaInactivaException;
import ar.edu.uade.banco.exceptions.CuentaNoEncontradaException;
import ar.edu.uade.banco.exceptions.DescubiertoInvalidoException;
import ar.edu.uade.banco.exceptions.DomicilioPostalRequeridoException;

public class Main {
    public static void main(String[] args) {
        ejemploManejoExeption();

        try {
            Banco.getInstancia().extraer(100001, "CCP100001", 300);
        } catch (ClienteNoEncontradoException | ClienteInactivoException | CuentaNoEncontradaException
                | DescubiertoInvalidoException | CuentaInactivaException e) {
            
            e.printStackTrace();
        }
    }

    private static void ejemploManejoExeption() {
        try {
            Cliente cliente1 = Banco.getInstancia()
                .crearCliente("35233233", "Nacho Colombo", "Mi casa 1234");

            System.out.println(cliente1.getNombre());
            
            Cliente clienteInvalido = Banco.getInstancia()
                .crearCliente("35233233", "Nacho Colombo", "Mi casa 1234", null, false);
            System.out.println(clienteInvalido.getNombre());
        } catch (DomicilioPostalRequeridoException e) {
            System.out.println(e.getMessage());
        }
    }
}
