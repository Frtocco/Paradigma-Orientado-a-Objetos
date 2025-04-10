package ar.edu.uade.banco.cuenta;

import ar.edu.uade.banco.Moneda;
import ar.edu.uade.banco.exceptions.CuentaInactivaException;
import ar.edu.uade.banco.exceptions.DescubiertoInvalidoException;
import ar.edu.uade.banco.operacion.Operacion;
import ar.edu.uade.banco.operacion.TipoOperacion;

public class CuentaCorriente extends Cuenta {
    private float limiteDescubierto;
    private float tasaDescubierto;

    protected CuentaCorriente(Moneda moneda, float costoMantenimiento, float limiteDescubierto, float tasaDescubierto) {
        super(moneda, costoMantenimiento);
        this.limiteDescubierto = limiteDescubierto;
        this.tasaDescubierto = tasaDescubierto;
    }

    @Override
    protected String getAbreviatura() {
        return "CC";
    }

    @Override
    public Operacion extraer(float monto) throws DescubiertoInvalidoException, CuentaInactivaException {
        if (this.estado != EstadoCuenta.ACTIVA) {
            throw new CuentaInactivaException("La cuenta no esta activa. Nro Cuenta: " + this.nroCuenta);
        }
        
        float nuevoSaldo = calcularNuevoSaldo(monto);
        if (nuevoSaldo < 0) {
            verificarDescubiertoValido(nuevoSaldo);
        }

        float saldoAnterior = this.saldo;
        this.saldo = nuevoSaldo;

        Operacion operacion = new Operacion(null, TipoOperacion.EXTRACCION, monto, saldoAnterior);
        this.operaciones.add(operacion);

        return operacion;
    }

    private void verificarDescubiertoValido(float nuevoSaldo) throws DescubiertoInvalidoException {
        if (!this.moneda.permiteDescubierto() || Math.abs(nuevoSaldo) > limiteDescubierto) {
            throw new DescubiertoInvalidoException("La moneda no permite descubierto o se sobrepaso el limite");
        }
    }

    private float calcularNuevoSaldo(float monto) {
        return this.saldo - monto;
    }
    

	@Override
	public Operacion depositar(float monto) throws CuentaInactivaException {
		
		if (this.estado != EstadoCuenta.ACTIVA) {
            throw new CuentaInactivaException("La cuenta no esta activa. Nro Cuenta: " + this.nroCuenta);
        }
		float nuevoSaldo = sumarSaldo(monto);
		
		float saldoAnterior = this.saldo;
		this.saldo = nuevoSaldo;
		
		return new Operacion(null, TipoOperacion.DEPOSITO, monto, saldoAnterior);
	}

   
}
