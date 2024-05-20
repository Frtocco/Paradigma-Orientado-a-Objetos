package ar.edu.uade.banco.operacion;

import java.util.Date;

import ar.edu.uade.banco.cliente.Cliente;

public class Operacion {
    private Cliente cliente;
    private TipoOperacion tipo;
    private float monto;
    private float saldoAnterior;
    private Date fecha;
    
    public Operacion(Cliente cliente, TipoOperacion tipo, float monto, float saldoAnterior) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;

        this.fecha = new Date();
    }

    
    
}
