package unlam.dominio;

import java.util.Set;
import java.util.TreeSet;

public class Vehiculos_Duenios{
	
	private Vehiculo vehiculo;
	private Set<Dueño> dueños;
	
	public Vehiculos_Duenios(Vehiculo vehiculo) {
		
		this.vehiculo = vehiculo;
		this.dueños = new TreeSet<>();
	}
	
	public void agregarDueño(Dueño dueño) {
		dueños.add(dueño);
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Set<Dueño> getDueños() {
		return dueños;
	}
	
}
