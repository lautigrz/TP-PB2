package unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concesionaria implements IConcesionaria {
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

	public boolean agregarVehiculosParaLaVenta(Vehiculo vehiculo) throws VehiculoInexistenteException {

		if (vehiculo == null) {
			throw new VehiculoInexistenteException();
		}
		return this.vehiculos.add(vehiculo);
	}

	public boolean agregarEmpleadosAlaConcesionaria(Empleado empleado) throws EmpleadoInexistenteException {
		if (empleado == null) {
			throw new EmpleadoInexistenteException();
		}
		return this.empleados.add(empleado);
	}

	@Override
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

	public Vehiculo buscarVehiculoPorPatente(String patente) throws VehiculoInexistenteException {

		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getPatente().equals(patente)) {
				return vehiculo;
			}
		}
		throw new VehiculoInexistenteException();// agregue el exception y modifique un poco la estructura del metodo
	}

	public List<Moto> obtenerMotos() throws ConcesionariaVaciaDeMotosException {
		/*
		 * Cambie el tipo de la lista para aplicar polimorfismo y castie el vehiculo
		 * para que no haya errores
		 */

		List<Moto> motos = new ArrayList<>();
		if(this.vehiculos.size()!=0) {
			for (Vehiculo v : this.vehiculos) {

				if (v instanceof Moto) {

					motos.add((Moto) v); // Casteo
				}
			}
		}
		throw new ConcesionariaVaciaDeMotosException("");
	}

	public List<Auto> obtenerAutos() throws ConcesionariaVaciaDeAutosException {
		/*
		 * Cambie el tipo de la lista para aplicar polimorfismo y castie el vehiculo
		 * para que no haya errores
		 */

		List<Auto> autos = new ArrayList<>();
		if(this.vehiculos.size() != 0) {
		
			for (Vehiculo v : this.vehiculos) {

				if (v instanceof Auto) {

					autos.add((Auto) v);// Casteo
				}
			}
			return autos;
		}
		
		throw new ConcesionariaVaciaDeAutosException("");

	}

	private void agregarVenta(Vehiculo vehiculo, Dueño dueñoComprador, LocalDate now) {

		Venta venta = new Venta(vehiculo, dueñoComprador, now);

		this.venta.add(venta);
	}

	private void vehiculos_dueño(Vehiculo vehiculo, Dueño dueñoComprador) {

		for (Vehiculos_Duenios v : listaDuenios) {

			if (v.getVehiculo().equals(vehiculo)) {

				v.agregarDueño(dueñoComprador);
			} else {

				Vehiculos_Duenios vehi = new Vehiculos_Duenios(vehiculo);

				this.listaDuenios.add(vehi);
			}
		}

	}

	// Agregado Por Jhony metodo para mostrar la lista de vehiculos y comprobar que
	// no este vacio
	// usando exeption.

	@Override
	public Set<Vehiculo> listaVehiculosDisponiblesParaVender() throws ConcesionariaVaciaException {

		if (!this.vehiculos.isEmpty()) {
			return this.vehiculos;
		}

		throw new ConcesionariaVaciaException("Concesionaria sin Vehiculos disponibles.");
	}

	// Agregado Por Jhony metodo para mostrar la lista de autos y comprobar que no
	// este vacio usando exeption.

	@Override
	public List<Auto> listaAutosDisponiblesParaVender() throws ConcesionariaVaciaDeAutosException {

		List<Auto> listaAutos = obtenerAutos();

		if (!listaAutos.isEmpty()) {
			return listaAutos;
		}
		throw new ConcesionariaVaciaDeAutosException("Concesionaria sin Autos disponibles.");
	}

	// Agregado Por Jhony metodo para mostrar la lista de Motos y comprobar que no
	// este vacio usando exeption.

	@Override
	public List<Moto> listaMotosDisponiblesParaVender() throws ConcesionariaVaciaDeMotosException {
		List<Moto> listaMotos = obtenerMotos();

		if (!listaMotos.isEmpty()) {
			return listaMotos;
		}

		throw new ConcesionariaVaciaDeMotosException("Concesionaria sin Autos disponibles.");
	}

}
