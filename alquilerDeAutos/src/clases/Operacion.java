package clases;
import clases.Vehiculo;
import clases.Cliente;

import java.util.Date;


public class Operacion {
	private String tipo;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private Date fechaInicio;
	private Date fechaFin;

		public Operacion(Vehiculo vehiculo, Date fechaInicio, Date fechaFin){
			this.vehiculo = vehiculo;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
		}

		public void setCliente(Cliente cliente){
			this.cliente = cliente;
		}


}
