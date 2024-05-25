package unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Concesionaria {
	private String nombre;
	List<Vehiculo> vehiculos;
	List<Venta> venta;
	List<Vehiculos_Duenios> listaDuenios;
	
	public Concesionaria(String nombre) {
		super();
		this.nombre = nombre;
		this.vehiculos = new ArrayList<>();
		this.venta = new ArrayList<>();
		this.listaDuenios = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public boolean agregarVehiculosParaLaVenta(Vehiculo vehiculo) {
		return this.vehiculos.add(vehiculo);
	}
	
}
