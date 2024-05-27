package unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concesionaria {
	private String nombre;
	Set<Vehiculo> vehiculos;
	List<Venta> venta;
	List<Vehiculos_Duenios> listaDuenios;
	Set<Empleado> empleados;

	public Concesionaria(String nombre) {
		super();
		this.nombre = nombre;
		this.vehiculos = new HashSet<>();
		this.venta = new ArrayList<>();
		this.listaDuenios = new ArrayList<>();
		this.empleados = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public boolean agregarVehiculosParaLaVenta(Vehiculo vehiculo) {
		return this.vehiculos.add(vehiculo);
	}

	public boolean agregarEmpleadosAlaConcesionaria(Empleado empleado) {
		return this.empleados.add(empleado);
	}

	public boolean generarVenta(Vehiculo vehiculo, Dueño dueñoComprador, Double saldoPagar) {

		for (Vehiculo v : this.vehiculos) {

			if (v.equals(vehiculo) && saldoPagar >= vehiculo.getPrecio()) {

				agregarVenta(vehiculo, dueñoComprador, LocalDate.now());
				vehiculos_dueño(vehiculo, dueñoComprador);

				return true;
			}
		}

		return false;
	}

	public List<Vehiculo> obtenerMotos() {

		List<Vehiculo> motos = new ArrayList<>();

		for (Vehiculo v : this.vehiculos) {

			if (v instanceof Moto) {

				motos.add(v);
			}
		}

		return motos;
	}
	
	public List<Vehiculo> obtenerAuto() {

		List<Vehiculo> motos = new ArrayList<>();

		for (Vehiculo v : this.vehiculos) {

			if (v instanceof Auto) {

				motos.add(v);
			}
		}

		return motos;

	}

	private void agregarVenta(Vehiculo vehiculo, Dueño dueñoComprador, LocalDate now) {
		// TODO Auto-generated method stub
		Venta venta = new Venta(vehiculo, dueñoComprador, now);

		this.venta.add(venta);
	}

	private void vehiculos_dueño(Vehiculo vehiculo, Dueño dueñoComprador) {
		// TODO Auto-generated method stub

		for (Vehiculos_Duenios v : listaDuenios) {

			if (v.getVehiculo().equals(vehiculo)) {

				v.agregarDueño(dueñoComprador);
			} else {

				Vehiculos_Duenios vehi = new Vehiculos_Duenios(vehiculo);

				this.listaDuenios.add(vehi);
			}
		}

	}

}
