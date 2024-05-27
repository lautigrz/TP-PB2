package unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {
	
	private Double comisionGanada;
	private List<Vehiculo> vehiculosVendidos;
	
	public Empleado(String nombre, String apellido, Integer edad, Integer dni, Double comisionGanada) {
		super(nombre, apellido, edad, dni);
		// TODO Auto-generated constructor stub
		this.comisionGanada = comisionGanada;
		this.vehiculosVendidos = new ArrayList<>();
	}

	public Double getComisionGanada() {
		return comisionGanada;
	}
	
	public void concederComision(Double comision) {
		
		this.comisionGanada += comision;		
	}
	
	
}
