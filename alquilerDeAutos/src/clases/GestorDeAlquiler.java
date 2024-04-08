package clases;

import clases.Vehiculo;
import clases.Operacion;
import clases.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

public class GestorDeAlquiler {
	
	private List<Vehiculo> vehiculos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private List<Operacion> operaciones = new ArrayList<>();
	
	public Operacion alquilar(String idCliente, String idVehiculo, Date fechaDesde, Date fechaHasta) {
		Cliente cliente = buscarCliente(idCliente);
		Vehiculo vehiculo = buscarVehiculo(idVehiculo);
		return cliente.alquilar(vehiculo, fechaDesde, fechaHasta);
	}
}
