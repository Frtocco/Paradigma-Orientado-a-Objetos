package clases;
import java.util.Random;
import java.sql.Date;

public class Cliente {
	private String nombreCliente;
	private String dni;
	private String id;
	
	public Cliente(String nombre, String dni, String id) {
		this.nombreCliente = nombre;
		this.dni = dni;
		this.id = String.valueOf(new Random().nextInt(0,100000));
	}
	
	public String getNombre() {
		return(nombreCliente);
	}
	
	public String getDni() {
		return dni;
	}
	
	public boolean sosCliente(String idCliente) {
		return(this.id.equals(idCliente));
	}
	
	public Operacion alquilar(Vehiculo vehiculo, Date fechaDesde, Date fechaHasta) {
		
	}
	
}
