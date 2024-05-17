package ar.edu.uade.banco.cuenta;

import ar.edu.uade.banco.Moneda;
import ar.edu.uade.banco.exceptions.CuentaInactivaException;
import ar.edu.uade.banco.exceptions.DescubiertoInvalidoException;
import ar.edu.uade.banco.operacion.Operacion;
import ar.edu.uade.banco.operacion.TipoOperacion;

public class CajaAhorro extends Cuenta {
    private float tasaInteres;

    protected CajaAhorro(Moneda moneda, float costoMantenimiento, float tasaInteres) {
        super(moneda, costoMantenimiento);
        this.tasaInteres = tasaInteres;
    }

    @Override
    protected String getAbreviatura() {
        return "CA";
    }

    @Override
    public Operacion extraer(float monto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extraer'");
        
    }

	@Override
	public Operacion depositar(float monto) throws DescubiertoInvalidoException, CuentaInactivaException {
		
		if (this.estado != EstadoCuenta.ACTIVA) {
            throw new CuentaInactivaException("La cuenta no esta activa. Nro Cuenta: " + this.nroCuenta);
        }
		float nuevoSaldo = sumarSaldo(monto);
		
		float saldoAnterior = this.saldo;
		this.saldo = nuevoSaldo;
		
		Operacion operacion = new Operacion(null, TipoOperacion.DEPOSITO, monto, saldoAnterior);
		
		return operacion;
	}
 
}
