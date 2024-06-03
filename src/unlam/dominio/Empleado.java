package unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {

	private Double comisionGanada = 0.0;
	private List<Vehiculo> vehiculosVendidos;
	private final Double PORCENTAJE_DESEADO = 15D;

	public Empleado(String nombre, String apellido, Integer edad, Integer dni) {
		super(nombre, apellido, edad, dni);
		// TODO Auto-generated constructor stub
		
		this.vehiculosVendidos = new ArrayList<>();
	}

	public void agregarVehiculoVendidoPorEmpleado(Vehiculo vehiculo) {
		this.vehiculosVendidos.add(vehiculo);
		comisionDeVehiculo(vehiculo);
	}

	private void comisionDeVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		Double comisionObtenida = (PORCENTAJE_DESEADO / 100) * vehiculo.getPrecio();
		this.comisionGanada += comisionObtenida;
	}

	public Double getComisionGanada() {
		return comisionGanada;
	}


}
