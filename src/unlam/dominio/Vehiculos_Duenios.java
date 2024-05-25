package unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vehiculos_Duenios {
	
	private Vehiculo vehiculo;
	private List<Dueño> dueños;
	
	public Vehiculos_Duenios(Vehiculo vehiculo) {
		
		this.vehiculo = vehiculo;
		this.dueños = new ArrayList<>();
	}
	
	public void agregarDueño(Dueño dueño) {
		dueños.add(dueño);
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public List<Dueño> getDueños() {
		return dueños;
	}
	
}
