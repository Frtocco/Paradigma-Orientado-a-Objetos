package ar.edu.uade.banco.cliente;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.banco.cuenta.Cuenta;
import ar.edu.uade.banco.exceptions.ClienteInactivoException;
import ar.edu.uade.banco.exceptions.CuentaInactivaException;
import ar.edu.uade.banco.exceptions.CuentaNoEncontradaException;
import ar.edu.uade.banco.exceptions.DescubiertoInvalidoException;
import ar.edu.uade.banco.exceptions.DomicilioPostalRequeridoException;
import ar.edu.uade.banco.operacion.Operacion;

public class Cliente {
    private static int contador = 100000;

    private int nroCliente;
    private String nroDocumento;
    private String nombre;
    private String domicilioFiscal;
    private String domicilioPostal;
    private boolean deseaResumenDigital;
    private EstadoCliente estado;
    private List<Cuenta> cuentas;
  
    public Cliente(
        String nroDocumento,
        String nombre,
        String domicilioFiscal,
        String domicilioPostal,
        boolean deseaResumenDigital
    ) throws DomicilioPostalRequeridoException {

        if (!deseaResumenDigital && domicilioFiscal == null) {
            throw new DomicilioPostalRequeridoException("El domicilio postal es requerido si no se desea el resumen digital");
        }

        this.nroCliente = Cliente.calcularIdentificador();
        this.nroDocumento = nroDocumento;
        this.nombre = nombre;
        this.domicilioFiscal = domicilioFiscal;
        this.domicilioPostal = domicilioPostal;
        this.deseaResumenDigital = deseaResumenDigital;

        this.deseaResumenDigital = true;
        this.estado = EstadoCliente.ACTIVO;
        this.cuentas = new ArrayList<>();
    }

    public Cliente(
        String nroDocumento,
        String nombre,
        String domicilioFiscal
    ) throws DomicilioPostalRequeridoException {
        this(nroDocumento, nombre, domicilioFiscal, null, true);
    }

    private static int calcularIdentificador() {
        return contador += 1;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean estaActivo() {
        return this.estado == EstadoCliente.ACTIVO;
    }

    public boolean tenesNroCliente(int nroCliente) {
        return this.nroCliente == nroCliente;
    }

    public Operacion extraer(String nroCuenta, float monto) throws ClienteInactivoException, CuentaNoEncontradaException, DescubiertoInvalidoException, CuentaInactivaException {
        validarEstadoActivo();
        Cuenta cuenta = buscarCuenta(nroCuenta);
        if (cuenta == null) {
            throw new CuentaNoEncontradaException("Cuenta no encontrada. Nro Cuenta: " + nroCuenta);
        }

        return cuenta.extraer(monto);
    }

    private Cuenta buscarCuenta(String nroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.sosCuenta(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    private void validarEstadoActivo() throws ClienteInactivoException {
        if (!estaActivo()) {
            throw new ClienteInactivoException("Cliente inactivo, no puede extraer. Nro Cliente: " + nroCliente);
        }
    }
    
    public Operacion depositar(String nroCuenta, float monto) throws ClienteInactivoException, CuentaNoEncontradaException, DescubiertoInvalidoException, CuentaInactivaException {
    	validarEstadoActivo();
    	Cuenta cuenta = buscarCuenta(nroCuenta);
        if (cuenta == null) {
            throw new CuentaNoEncontradaException("Cuenta no encontrada. Nro Cuenta: " + nroCuenta);
        }
        return cuenta.depositar(monto);
    	
    }

    public float consultarSaldo(String idCuenta){
        Cuenta cuenta = buscarCuenta(idCuenta);
        return cuenta.getSaldo();
    }
}
