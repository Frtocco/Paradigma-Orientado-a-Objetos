package ar.edu.uade.banco;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.banco.cliente.Cliente;
import ar.edu.uade.banco.cuenta.Cuenta;
import ar.edu.uade.banco.exceptions.ClienteInactivoException;
import ar.edu.uade.banco.exceptions.ClienteNoEncontradoException;
import ar.edu.uade.banco.exceptions.CuentaInactivaException;
import ar.edu.uade.banco.exceptions.CuentaNoEncontradaException;
import ar.edu.uade.banco.exceptions.DescubiertoInvalidoException;
import ar.edu.uade.banco.exceptions.DomicilioPostalRequeridoException;
import ar.edu.uade.banco.operacion.Operacion;

public class Banco {
    private static Banco instancia = new Banco();

    private List<Cliente> clientes;
    private List<Cuenta> cuentas;

    private Banco() {
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
    }

    public static Banco getInstancia() {
        return instancia;
    }

    public Cliente crearCliente(String nroDocumento, String nombre, String domicilioFiscal) throws DomicilioPostalRequeridoException {
        Cliente cliente = new Cliente(nroDocumento, nombre, domicilioFiscal);
        this.clientes.add(cliente);
        return cliente;
    }

    public Cliente crearCliente(String nroDocumento, String nombre, String domicilioFiscal, String domicilioPostal, boolean deseaResumenDigital) throws DomicilioPostalRequeridoException {
        Cliente cliente = new Cliente(nroDocumento, nombre, domicilioFiscal, domicilioPostal, deseaResumenDigital);
        this.clientes.add(cliente);
        return cliente;
    }
    
    public Operacion extraer(int nroCliente, String nroCuenta, float monto) throws ClienteNoEncontradoException, ClienteInactivoException, CuentaNoEncontradaException, DescubiertoInvalidoException, CuentaInactivaException {
        Cliente cliente = buscarCliente(nroCliente);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado. NroCliente:" + nroCliente);
        }
        return cliente.extraer(nroCuenta, monto);
    }

    private Cliente buscarCliente(int nroCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.tenesNroCliente(nroCliente)) {
                return cliente;
            }
        }
        return null;
    }
    
    public Operacion depositar(int nroCliente, String nroCuenta, float monto)throws ClienteNoEncontradoException, ClienteInactivoException, CuentaNoEncontradaException, DescubiertoInvalidoException, CuentaInactivaException  {
    	Cliente cliente = buscarCliente(nroCliente);
    	if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado. NroCliente:" + nroCliente);
        }
    	return cliente.depositar(nroCuenta, monto);
    }
    
}
