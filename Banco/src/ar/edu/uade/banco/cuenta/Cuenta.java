package ar.edu.uade.banco.cuenta;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.banco.Moneda;
import ar.edu.uade.banco.cliente.Cliente;
import ar.edu.uade.banco.exceptions.CuentaInactivaException;
import ar.edu.uade.banco.exceptions.DescubiertoInvalidoException;
import ar.edu.uade.banco.operacion.Operacion;

public abstract class Cuenta {
    private static int contador = 100000;

    protected String nroCuenta;
    protected Moneda moneda;
    protected EstadoCuenta estado;
    protected float saldo;
    protected float costoMantenimiento;
    protected List<Cliente> titulares;
    protected List<Operacion> operaciones;
    
    protected Cuenta(Moneda moneda, float costoMantenimiento) {
        this.moneda = moneda;
        this.costoMantenimiento = costoMantenimiento;

        this.nroCuenta = calcularNroCuenta(moneda);
        
        this.saldo = 0;
        this.estado = EstadoCuenta.ACTIVA;
        this.titulares = new ArrayList<>();
        this.operaciones = new ArrayList<>();
    }

    protected static int calcularIdentificador() {
        return contador += 1;
    }

    private String calcularNroCuenta(Moneda moneda) {
        return this.getAbreviatura() + moneda.getNombreCorto() + Cuenta.calcularIdentificador();
    }
    
    public boolean sosCuenta(String nroCuenta) {
        return this.nroCuenta == nroCuenta;
    }
    
    protected float sumarSaldo(float monto) {
    	return this.saldo + monto;
    }
    
    protected abstract String getAbreviatura();

    public abstract Operacion extraer(float monto) throws DescubiertoInvalidoException, CuentaInactivaException;
    public abstract Operacion depositar(float monto) throws DescubiertoInvalidoException, CuentaInactivaException;
    
}
